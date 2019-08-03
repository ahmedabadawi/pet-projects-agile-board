package playground.agileboard.security.web;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;
import playground.agileboard.security.JwtDecoder;
import playground.agileboard.security.TokenBasedPrinciple;
import playground.agileboard.service.AuthService;

public class TokenAuthenticationFilter extends OncePerRequestFilter {
  private static final Logger LOG = LoggerFactory.getLogger(TokenAuthenticationFilter.class);
  private static final String AUTH_HEADER = "Authorization";
  private static final String AUTH_HEADER_PREFIX = "Bearer ";

  private final JwtDecoder jwtDecoder;
  private final AuthService authService;

  public TokenAuthenticationFilter(final JwtDecoder jwtDecoder, final AuthService authService) {
    this.jwtDecoder = jwtDecoder;
    this.authService = authService;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {

    final String token = extractToken(request);
    if (token != null) {
      final String username = jwtDecoder.getUsername(token);
      if (username != null) {
        final UserDetails user = authService.loadUserByUsername(username);
        if (jwtDecoder.validate(token, user)) {
          final TokenBasedPrinciple principle = new TokenBasedPrinciple(token, user);
          SecurityContextHolder.getContext().setAuthentication(principle);
        }
      }
    }

    filterChain.doFilter(request, response);
  }

  private static String extractToken(final HttpServletRequest request) {
    final String authHeader = extractAuthHeader(request);
    return (authHeader != null && authHeader.startsWith(AUTH_HEADER_PREFIX))
        ? authHeader.substring(AUTH_HEADER_PREFIX.length())
        : null;
  }

  private static String extractAuthHeader(final HttpServletRequest request) {
    return request.getHeader(AUTH_HEADER);
  }
}

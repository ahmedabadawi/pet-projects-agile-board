package playground.agileboard.security;

import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtDecoder {
  @Value("${jwt.secret}")
  private String secret;

  public boolean validate(final String token, final UserDetails user) {
    final String username = getUsername(token);

    return username != null && username.contentEquals(user.getUsername());
  }

  public String getUsername(final String token) {
    final Claims claims = decodeClaims(token);
    return claims.getSubject();
  }

  public Date getIssuedAtDate(final String token) {
    final Claims claims = decodeClaims(token);
    return claims.getIssuedAt();
  }

  private Claims decodeClaims(final String token) {
    return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
  }

}

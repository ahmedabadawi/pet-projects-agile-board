package playground.agileboard.security;

import java.time.Instant;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtEncoder {
  private static final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;

  @Value("${jwt.issuer}")
  private String issuer;

  @Value("${jwt.secret}")
  private String secret;

  @Value("${jwt.expires_in}")
  private int expiresIn;

  public String generate(final UserDetails user) {
    final Instant issuedAt = Instant.now();
    return Jwts.builder().setIssuer(issuer).setSubject(user.getUsername())
        .setIssuedAt(Date.from(issuedAt)).setExpiration(Date.from(calculateExpiration(issuedAt)))
        .signWith(SIGNATURE_ALGORITHM, secret).compact();
  }

  public String refresh(final String token) {
    final Instant issuedAt = Instant.now();
    final Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    claims.setIssuedAt(Date.from(issuedAt));
    return Jwts.builder().setClaims(claims).setExpiration(Date.from(calculateExpiration(issuedAt)))
        .signWith(SIGNATURE_ALGORITHM, secret).compact();
  }

  private Instant calculateExpiration(final Instant instant) {
    return instant.plusSeconds(expiresIn);
  }
}

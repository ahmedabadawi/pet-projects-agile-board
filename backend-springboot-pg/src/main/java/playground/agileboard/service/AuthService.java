package playground.agileboard.service;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import playground.agileboard.AppConfig;
import playground.agileboard.model.AuthToken;
import playground.agileboard.model.LoginUser;
import playground.agileboard.repository.AuthRepository;

@Service
public class AuthService {
  private static final Logger LOGGER = LoggerFactory.getLogger(AuthService.class);

  private final AppConfig config;
  private final HashService hashService;
  private final AuthRepository authRepository;

  @Autowired
  public AuthService(final AppConfig config, final HashService hashService,
      final AuthRepository authRepository) {
    this.config = config;
    this.hashService = hashService;
    this.authRepository = authRepository;
  }

  public AuthToken login(final String email, final String password) throws AuthenticationException {
    validateConfig();
    
    if (email == null || password == null) {
      throw new AuthenticationException();
    }
    
    final String hashedPassword = hashService.hash(password);
    Optional<LoginUser> loginUser = authRepository.findById(email);
    if (loginUser.isPresent()) {
      if (loginUser.get().getPasswordHash().equals(hashedPassword)) {
        final Integer userId = loginUser.get().getUserId();
        final Algorithm algorithm = Algorithm.HMAC256(config.getAuth().getSecret());
        final Instant expiresAt = Instant.now().plusSeconds(config.getAuth().getExpiry());
        try {
          final String token = JWT.create().withIssuer(config.getAuth().getIssuer())
              .withExpiresAt(Date.from(expiresAt)).withSubject(String.valueOf(userId))
              .sign(algorithm);

          return new AuthToken(userId, token, expiresAt);
        } catch (JWTCreationException e) {
          LOGGER.error("Error Creating JWT Token", e);
          throw e;
        }
      }
    }
    LOGGER.info("Invalid credentials for {}", email);
    throw new AuthenticationException();
  }

  private void validateConfig() {
    try {
      if (config.getAuth() == null) {
        throw new ConfigurationException();
      }
      if (config.getAuth().getSecret() == null) {
        throw new ConfigurationException("auth.secret");
      }
      if (config.getAuth().getIssuer() == null) {
        throw new ConfigurationException("auth.issuer");

      }
      if (config.getAuth().getExpiry() == null) {
        throw new ConfigurationException("auth.expiry");
      }

    } catch (ConfigurationException e) {
      LOGGER.error(e.getMessage(), e);
      throw e;
    }
  }
}

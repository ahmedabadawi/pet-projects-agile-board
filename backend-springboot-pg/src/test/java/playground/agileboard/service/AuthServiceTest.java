package playground.agileboard.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.time.Instant;
import java.util.Optional;
import javax.security.auth.message.MessageInfo;
import javax.security.auth.message.config.AuthConfig;
import org.junit.Before;
import org.junit.Test;
import playground.agileboard.AppConfig;
import playground.agileboard.model.AuthToken;
import playground.agileboard.model.LoginUser;
import playground.agileboard.repository.AuthRepository;

public class AuthServiceTest {
  private static final String tokenSecret = "Password123";
  private static final Integer expiry = 3600;
  private static final String issuer = "agileboard-test";
  
  private HashService hashService;
  private AppConfig config;
  
  @Before
  public void setup() {
    this.hashService = new HashService();
    this.config = new AppConfig();
    final AppConfig.AuthConfig authConfig = new AppConfig.AuthConfig();
    authConfig.setSecret(tokenSecret);
    authConfig.setIssuer(issuer);
    authConfig.setExpiry(expiry);
    this.config.setAuth(authConfig);
  }
  
  @Test
  public void validLogin() {
    final Integer userId = 999;
    final String email = "admin@corp.com";
    final String password = "Password123";
    final String hashedPassword = hashService.hash(password);
    final Instant expiresAt = Instant.now().plusSeconds(expiry);
    final AuthRepository authRepository = mock(AuthRepository.class);
    when(authRepository.findById(eq(email)))
      .thenReturn(Optional.of(new LoginUser(email, hashedPassword, userId)));
    final AuthService service = new AuthService(this.config, this.hashService, authRepository);
    try {
      final AuthToken actual = service.login(email, password);
      assertNotNull(actual);
      assertEquals(userId, actual.getUserId());
      //assertEquals(expiresAt, actual.getExpiresAt());
      // TODO: test the expiresAt with a bit of tolerance
      // TODO: test the created JWT Token
    } catch (AuthenticationException e) {
      fail(e.getMessage());
    }
  }
  
  @Test
  public void invalidLogin_emailDoesNotExist() {}
  
  @Test
  public void invalidLogin_passwordDoesNotMatch() {}
  
  @Test
  public void missingConfig_secret() {}
  
  @Test
  public void missingConfig_issuer() {}
  
  @Test
  public void missingConfig_expiry() {}
}

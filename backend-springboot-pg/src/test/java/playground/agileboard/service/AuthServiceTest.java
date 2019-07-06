package playground.agileboard.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import java.time.Instant;
import java.util.Optional;
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

  private static final Integer USER_ID = 999;
  private static final String USER_EMAIL = "admin@corp.com";
  private static final String USER_PASSWORD = "Password123";
  
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
    final String hashedPassword = hashService.hash(USER_PASSWORD);
    final Instant expiresAt = Instant.now().plusSeconds(expiry);
    final AuthRepository authRepository = mock(AuthRepository.class);
    when(authRepository.findById(eq(USER_EMAIL)))
        .thenReturn(Optional.of(new LoginUser(USER_EMAIL, hashedPassword, USER_ID)));
    final AuthService service = new AuthService(this.config, this.hashService, authRepository);
    try {
      final AuthToken actual = service.login(USER_EMAIL, USER_PASSWORD);
      assertThat(actual).isNotNull();
      assertThat(actual.getUserId()).isEqualTo(USER_ID);
      // assertEquals(expiresAt, actual.getExpiresAt());
      // TODO: test the expiresAt with a bit of tolerance
      // TODO: test the created JWT Token
    } catch (AuthenticationException e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void invalidLogin_emailDoesNotExist() {
    final AuthRepository authRepository = mock(AuthRepository.class);
    when(authRepository.findById(eq(USER_EMAIL))).thenReturn(Optional.empty());
    final AuthService service = new AuthService(this.config, this.hashService, authRepository);
    assertThatThrownBy(() -> service.login(USER_EMAIL, USER_PASSWORD))
        .isInstanceOf(AuthenticationException.class);
  }

  @Test
  public void invalidLogin_passwordDoesNotMatch() {
    final String password = USER_PASSWORD.toLowerCase();
    final String hashedPassword = hashService.hash(USER_PASSWORD.toUpperCase());
    final AuthRepository authRepository = mock(AuthRepository.class);
    when(authRepository.findById(eq(USER_EMAIL)))
        .thenReturn(Optional.of(new LoginUser(USER_EMAIL, hashedPassword, USER_ID)));
    final AuthService service = new AuthService(this.config, this.hashService, authRepository);
    assertThatThrownBy(() -> service.login(USER_EMAIL, password))
        .isInstanceOf(AuthenticationException.class);
  }

  @Test
  public void invalidLogin_emailNull() {
    final AuthRepository authRepository = mock(AuthRepository.class);
    final AuthService service = new AuthService(this.config, this.hashService, authRepository);
    assertThatThrownBy(() -> service.login(null, USER_PASSWORD))
        .isInstanceOf(AuthenticationException.class);
    verifyNoMoreInteractions(authRepository);
  }
  
  @Test
  public void invalidLogin_passwordNull() {
    final AuthRepository authRepository = mock(AuthRepository.class);
    final AuthService service = new AuthService(this.config, this.hashService, authRepository);
    assertThatThrownBy(() -> service.login(USER_EMAIL, null))
        .isInstanceOf(AuthenticationException.class);
    verifyNoMoreInteractions(authRepository);
  }
  
  @Test
  public void missingConfig_secret() {
    final String hashedPassword = hashService.hash(USER_PASSWORD);
    final AuthRepository authRepository = mock(AuthRepository.class);
    
    this.config.getAuth().setSecret(null);
    
    when(authRepository.findById(eq(USER_EMAIL)))
        .thenReturn(Optional.of(new LoginUser(USER_EMAIL, hashedPassword, USER_ID)));
    final AuthService service = new AuthService(this.config, this.hashService, authRepository);
    assertThatThrownBy(() -> service.login(USER_EMAIL, USER_PASSWORD))
        .isInstanceOf(ConfigurationException.class);
  }

  @Test
  public void missingConfig_issuer() {
    final String hashedPassword = hashService.hash(USER_PASSWORD);
    final AuthRepository authRepository = mock(AuthRepository.class);
    
    this.config.getAuth().setIssuer(null);
    
    when(authRepository.findById(eq(USER_EMAIL)))
        .thenReturn(Optional.of(new LoginUser(USER_EMAIL, hashedPassword, USER_ID)));
    final AuthService service = new AuthService(this.config, this.hashService, authRepository);
    assertThatThrownBy(() -> service.login(USER_EMAIL, USER_PASSWORD))
        .isInstanceOf(ConfigurationException.class);
  }

  @Test
  public void missingConfig_expiry() {
    final String hashedPassword = hashService.hash(USER_PASSWORD);
    final AuthRepository authRepository = mock(AuthRepository.class);
    
    this.config.getAuth().setExpiry(null);
    
    when(authRepository.findById(eq(USER_EMAIL)))
        .thenReturn(Optional.of(new LoginUser(USER_EMAIL, hashedPassword, USER_ID)));
    final AuthService service = new AuthService(this.config, this.hashService, authRepository);
    assertThatThrownBy(() -> service.login(USER_EMAIL, USER_PASSWORD))
        .isInstanceOf(ConfigurationException.class);
  }
}

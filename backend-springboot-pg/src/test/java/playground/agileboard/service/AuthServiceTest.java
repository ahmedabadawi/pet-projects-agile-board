package playground.agileboard.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import playground.agileboard.model.LoginUser;
import playground.agileboard.repository.AuthRepository;

public class AuthServiceTest {
  private static final Integer USER_ID = 999;
  private static final String USER_EMAIL = "admin@corp.com";
  private static final String USER_PASSWORD = "Password123";
  private static final String USER_ROLES = "ADMIN,USER";

  private PasswordEncoder passwordEncoder;

  @Before
  public void setup() {
    this.passwordEncoder = new BCryptPasswordEncoder(4);
  }

  @Test
  public void validLogin() {
    final String hashedPassword = passwordEncoder.encode(USER_PASSWORD);
    final AuthRepository authRepository = mock(AuthRepository.class);
    when(authRepository.findById(eq(USER_EMAIL)))
        .thenReturn(Optional.of(new LoginUser(USER_EMAIL, hashedPassword, USER_ID, USER_ROLES)));

    final AuthServiceImpl service = new AuthServiceImpl(authRepository, passwordEncoder);
    try {
      final UserDetails actual = service.loadUserByUsername(USER_EMAIL);
      assertThat(actual).isNotNull().isInstanceOf(LoginUser.class);
      assertThat(((LoginUser) actual).getUserId()).isEqualTo(USER_ID);
      // assertEquals(expiresAt, actual.getExpiresAt());
      // TODO: test the expiresAt with a bit of tolerance
      // TODO: test the created JWT Token
    } catch (UsernameNotFoundException e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void invalidLogin_emailDoesNotExist() {
    final AuthRepository authRepository = mock(AuthRepository.class);
    when(authRepository.findById(eq(USER_EMAIL))).thenReturn(Optional.empty());
    final AuthServiceImpl service = new AuthServiceImpl(authRepository, passwordEncoder);
    assertThatThrownBy(() -> service.loadUserByUsername(USER_EMAIL))
        .isInstanceOf(UsernameNotFoundException.class);
  }

  @Test
  public void invalidLogin_emailNull() {
    final AuthRepository authRepository = mock(AuthRepository.class);
    final AuthServiceImpl service = new AuthServiceImpl(authRepository, passwordEncoder);
    assertThatThrownBy(() -> service.loadUserByUsername(null))
        .isInstanceOf(UsernameNotFoundException.class);
  }
}

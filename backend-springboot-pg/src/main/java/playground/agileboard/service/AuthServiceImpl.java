package playground.agileboard.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import playground.agileboard.model.LoginUser;
import playground.agileboard.repository.AuthRepository;

@Service
public class AuthServiceImpl implements AuthService {
  private static final Logger LOG = LoggerFactory.getLogger(AuthServiceImpl.class);

  private final AuthRepository authRepository;

  private final PasswordEncoder passwordEncoder;    // TODO: will be used in password change

  @Autowired
  public AuthServiceImpl(final AuthRepository authRepository, final PasswordEncoder passwordEncoder) {
    this.authRepository = authRepository;

    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
    Optional<LoginUser> loginUser = authRepository.findById(username);
    return loginUser.orElseThrow(
        () -> new UsernameNotFoundException(String.format("User %s is not found", username)));
  }
}

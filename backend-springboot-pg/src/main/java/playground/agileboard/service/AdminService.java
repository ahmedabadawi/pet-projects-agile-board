package playground.agileboard.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import playground.agileboard.model.LoginUser;
import playground.agileboard.model.User;
import playground.agileboard.model.UserProfile;
import playground.agileboard.repository.AuthRepository;
import playground.agileboard.repository.UserProfileRepository;
import playground.agileboard.repository.UserRepository;

@Service
public class AdminService {
  private final HashService hashService;
  
  private final AuthRepository authRepository;
  private final UserRepository userRepository;
  private final UserProfileRepository profileRepository;
  
  @Autowired
  public AdminService(final HashService hashService,
                      final AuthRepository authRepository,
                      final UserRepository userRepository,
                      final UserProfileRepository profileRepository) {
    this.hashService = hashService;
    
    this.userRepository = userRepository;
    this.authRepository = authRepository;
    this.profileRepository = profileRepository;
  }
  
  public List<User> getUsers() {
    final List<User> result = new ArrayList<>();
    userRepository.findAll().forEach(result::add);
    return result;
  }
  
  public void createUser(final User user) {
    final String generatedPasswordHash = hashService.hash(DEFAULT_PASSWORD);
    final User createdUser = this.userRepository.save(user);
    authRepository.save(
        new LoginUser(user.getEmail(), generatedPasswordHash, createdUser.getId()));
    profileRepository.save(
        new UserProfile(createdUser.getId(), createdUser.getEmail(), 
            createdUser.getFirstName(), createdUser.getLastName(), 
            null, null));
  }
  
  private static final String DEFAULT_PASSWORD = "Password123";
}

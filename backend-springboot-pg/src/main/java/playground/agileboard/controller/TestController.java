package playground.agileboard.controller;

import java.security.Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import playground.agileboard.model.LoginUser;
import playground.agileboard.model.User;
import playground.agileboard.repository.UserRepository;
import playground.agileboard.service.AuthService;
import playground.agileboard.service.SeederService;

@RestController
public class TestController {
  private Logger LOG = LoggerFactory.getLogger(TestController.class);
  
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private SeederService seeder;
  
  @Autowired
  private AuthService authService;
  
  public TestController() {}
  
  @RequestMapping("/")
  public String test() {
    final User test = new User();
    test.setFirstName("John");
    test.setLastName("Doe");
    test.setEmail("john.doe@life.com");
    test.setStatus("ACTIVE");
    this.userRepository.save(test);
    final StringBuilder tempString = new StringBuilder();
    this.userRepository.findAll()
      .forEach(user -> tempString.append(
          user.getFirstName() + " " + 
          user.getLastName() + " - " + 
          user.getEmail()));
    return "It is working - " + tempString.toString();
  }
  
  
  @RequestMapping("/seed")
  public String seedData() {
    try {
      seeder.seed();
      return "<h1>Data Seed Completed</h1>";
    } catch (Throwable e) {
      return e.getMessage();
    }
  }
  
  @RequestMapping("/whoami")
  @PreAuthorize("hasAuthority('USER')")
  public LoginUser whoami(Principal principal) {
    LOG.debug("Principal Name: {}", principal.getName());
    final LoginUser user = (LoginUser) authService.loadUserByUsername(principal.getName());
    LOG.debug("User {} - {} - {} - {}",
        user.getUsername(), user.getPassword(), user.getUserId(), user.getRoles());
    
    return user;
  }
  
  @RequestMapping("/am-i-an-admin")
  @PreAuthorize("hasAuthority('ADMIN')")
  public String isAdmin(Principal principal) {
    return "If you can see this, then you are!!!";
  }
}

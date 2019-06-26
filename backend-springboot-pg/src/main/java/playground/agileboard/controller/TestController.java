package playground.agileboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import playground.agileboard.model.User;
import playground.agileboard.repository.UserRepository;
import playground.agileboard.service.SeederService;

@RestController
public class TestController {
  private final UserRepository userRepository;
  private final SeederService seeder;
  
  @Autowired
  public TestController(final UserRepository userRepository, final SeederService seeder) {
    this.userRepository = userRepository;
    this.seeder = seeder;
  }
  
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
}

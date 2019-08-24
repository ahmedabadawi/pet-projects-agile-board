package playground.agileboard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import playground.agileboard.controller.dto.UserProfile;

@RestController
public class ProfileController {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProfileController.class);
  
  public ProfileController() {}
  
  @RequestMapping(
      value = "/api/profile/{userId}",
      method = RequestMethod.GET)
  public ResponseEntity<UserProfile> getUserProfile(@PathVariable Integer userId) {
    LOGGER.debug("Get User Profile for User Id - {}", userId);
    // TODO: Retrieve User Profile from Database and remove mocked response
    final UserProfile userProfile = new UserProfile();
    userProfile.setId(userId);
    userProfile.setEmail("admin@corp.com");
    userProfile.setFirstName("John");
    userProfile.setLastName("Doe");
    userProfile.setPhoto("https://placeimg.com/200/200/people");
    userProfile.setBio("lorem ipsum");
    
    return ResponseEntity.ok(userProfile);
  }
}

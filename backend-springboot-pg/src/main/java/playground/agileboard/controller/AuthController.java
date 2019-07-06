package playground.agileboard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import playground.agileboard.controller.dto.AuthToken;
import playground.agileboard.controller.dto.Credentials;
import playground.agileboard.service.AuthService;
import playground.agileboard.service.AuthenticationException;

@RestController
public class AuthController {
  private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);
  
  private static final String MIME_APPLICATION_JSON = "application/json";
  
  private final AuthService authService;
  
  @Autowired
  public AuthController(final AuthService authService) {
    this.authService = authService;
  }
  
  @RequestMapping(
      value = "/api/auth", 
      method = RequestMethod.POST,
      consumes = MIME_APPLICATION_JSON,
      produces = MIME_APPLICATION_JSON)
  public ResponseEntity<AuthToken> login(@RequestBody Credentials credentials) {
    LOGGER.debug("Auth - {}", credentials.getEmail());
    try {
      if (validate(credentials)) {
        return ResponseEntity.ok(AuthToken.fromModel(
            authService.login(credentials.getEmail(), credentials.getPassword())));
      } else {
        return ResponseEntity.badRequest().body(null);   
      }
    } catch (final AuthenticationException e) {
      return ResponseEntity.status(401).body(null);
    } catch (RuntimeException e) {
      LOGGER.error(e.getMessage(), e);
      return ResponseEntity.status(500).body(null);
    }
  }
  
  private boolean validate(final Credentials credentials) {
    return credentials != null;
  }
}

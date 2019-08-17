package playground.agileboard.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import playground.agileboard.controller.dto.AuthToken;
import playground.agileboard.controller.dto.Credentials;
import playground.agileboard.model.LoginUser;
import playground.agileboard.security.JwtEncoder;

@RestController
public class AuthController {
  private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);
  
  private static final String MIME_APPLICATION_JSON = "application/json";
  
  private final AuthenticationManager authenticationManager;
  
  private final JwtEncoder jwtEncoder;
  
  @Autowired
  public AuthController(final AuthenticationManager authenticationManager, 
                        final JwtEncoder jwtEncoder) { 
    this.authenticationManager = authenticationManager;
    this.jwtEncoder = jwtEncoder;
  }
  
  @RequestMapping(
      value = "/auth/login", 
      method = RequestMethod.POST,
      consumes = MIME_APPLICATION_JSON,
      produces = MIME_APPLICATION_JSON)
  public ResponseEntity<?> login(@RequestBody Credentials credentials) 
    throws AuthenticationException {
    LOGGER.debug("Auth - {}", credentials.getEmail());
    try {
      if (validate(credentials)) {
        final Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                credentials.getEmail(),
                credentials.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final LoginUser user = (LoginUser) authentication.getPrincipal();
        final String token = jwtEncoder.generate(user);
        
        return ResponseEntity.ok(new AuthToken(user.getUserId(), token));        
      } else {
        return ResponseEntity.badRequest().body(null);   
      }
    } catch (AuthenticationException e) {
      LOGGER.warn("Invalid Credentials");
      throw e;
    } catch (RuntimeException e) {
      LOGGER.error(e.getMessage(), e);
      return ResponseEntity.status(500).body(null);
    }
  }
  
  private boolean validate(final Credentials credentials) {
    return credentials != null;
  }
}

package playground.agileboard.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import playground.agileboard.controller.dto.Credentials;
import playground.agileboard.model.LoginUser;
import playground.agileboard.repository.AuthRepository;
import playground.agileboard.repository.ProjectMemberRepository;
import playground.agileboard.repository.ProjectRepository;
import playground.agileboard.repository.UserProfileRepository;
import playground.agileboard.repository.UserRepository;
import playground.agileboard.repository.WorkItemRepository;
import playground.agileboard.service.AuthService;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthController.class)
public class AuthControllerTest {
  private static ObjectMapper MAPPER = new ObjectMapper();
  
  @Autowired
  private PasswordEncoder passwordEncoder;
  
  @Autowired
  private MockMvc mvc;
  
  @MockBean
  private AuthService authService;
    
  @Test
  public void validCredentials_200() throws Exception {
    final Credentials request = new Credentials();
    request.setEmail("admin@corp.com");
    request.setPassword("Password123");
    final Integer userId = 999;
    
    when(authService.loadUserByUsername(request.getEmail()))
      .thenReturn(new LoginUser(request.getEmail(), passwordEncoder.encode(request.getPassword()), userId, "ADMIN,USER"));
    
    mvc.perform(post("/auth/login")
        .contentType(MediaType.APPLICATION_JSON)
        .content(MAPPER.writeValueAsBytes(request)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.userId", is(userId)));
        // .andExpect(jsonPath("$.expiresAt", is(expiresAt)));
    // TODO: Assert the expiresAt with a range matcher
  }
  
  @Test
  public void invalidCredentials_401() throws Exception {
    final Credentials request = new Credentials();
    request.setEmail("admin@corp.com");
    request.setPassword("Password123");
    
    when(authService.loadUserByUsername(request.getEmail()))
      .thenThrow(new UsernameNotFoundException("User is not found"));
    
    mvc.perform(post("/api/auth")
        .contentType(MediaType.APPLICATION_JSON)
        .content(MAPPER.writeValueAsBytes(request)))
        .andExpect(status().isUnauthorized());
  }
  
  // TODO: Fix No Qualifying bean of type... for not used beans
  @MockBean private UserRepository userRepository;
  @MockBean private AuthRepository authRepository;
  @MockBean private ProjectMemberRepository memberRepository;
  @MockBean private ProjectRepository projectRepository;
  @MockBean private UserProfileRepository profileRepository;
  @MockBean private WorkItemRepository workItemRepository;
}

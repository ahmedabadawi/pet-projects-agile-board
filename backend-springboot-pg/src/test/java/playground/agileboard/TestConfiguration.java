package playground.agileboard;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import playground.agileboard.repository.AuthRepository;
import playground.agileboard.repository.ProjectDetailsRepository;
import playground.agileboard.repository.ProjectMemberRepository;
import playground.agileboard.repository.ProjectRepository;
import playground.agileboard.repository.UserProfileRepository;
import playground.agileboard.repository.WorkItemRepository;

@Configuration
public class TestConfiguration {
  // TODO: Fix No Qualifying bean of type... for not used beans
  
  @MockBean
  private ProjectRepository projectRepository;
  
  @MockBean
  private ProjectDetailsRepository projectDetailsRepository;

  @MockBean
  private ProjectMemberRepository projectMemberRepository;
  
  @MockBean
  private WorkItemRepository workItemRepository;
  
  @MockBean
  private UserProfileRepository userProfileRepository;
  
  @MockBean
  private AuthRepository authRepository;
}

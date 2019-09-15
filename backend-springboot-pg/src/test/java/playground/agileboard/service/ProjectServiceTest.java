package playground.agileboard.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import playground.agileboard.model.ProjectDetails;
import playground.agileboard.repository.ProjectDetailsRepository;
import playground.agileboard.repository.ProjectRepository;

public class ProjectServiceTest {
  final String ADMIN_EMAIL = "admin@corp.com";
  final String ADMIN_FIRST_NAME = "John";
  final String ADMIN_LAST_NAME  = "Doe";
  
  final ProjectDetails PROJECT_1 = new ProjectDetails(1, "XYZ", "Project XYZ", "Lorem Ipsum XYZ",
      Instant.parse("2018-01-01T00:00:00.00Z"), Instant.parse("2022-01-01T00:00:00.00Z"), 1,
      ADMIN_EMAIL, ADMIN_FIRST_NAME, ADMIN_LAST_NAME);
  final ProjectDetails PROJECT_2 = new ProjectDetails(2, "ABC", "Project ABC", "Lorem Ipsum ABC",
      Instant.parse("2019-01-01T00:00:00.00Z"), Instant.parse("2023-01-01T00:00:00.00Z"), 1,
      ADMIN_EMAIL, ADMIN_FIRST_NAME, ADMIN_LAST_NAME);

 
  private ProjectRepository projectRepository;
  private ProjectDetailsRepository projectDetailsRepository;
  
  @Before
  public void setup() {
    this.projectRepository = mock(ProjectRepository.class);
    this.projectDetailsRepository = mock(ProjectDetailsRepository.class);
  }

  @Test
  public void getProject_2_projects() {
    when(projectDetailsRepository.findAll()).thenReturn(Arrays.asList(PROJECT_1, PROJECT_2));
    
    final ProjectService service = createService();
    
    final List<ProjectDetails> actual = service.getProjects();
    assertThat(actual).isNotNull().hasSize(2).containsExactlyInAnyOrder(PROJECT_1, PROJECT_2);
  }
  
  @Test
  public void getProject_1_project() {
    when(projectDetailsRepository.findAll()).thenReturn(Arrays.asList(PROJECT_1));
    
    final ProjectService service = createService();
    
    final List<ProjectDetails> actual = service.getProjects();
    assertThat(actual).isNotNull().hasSize(1).contains(PROJECT_1);
  }
  
  @Test
  public void getProject_0_projects() {
    when(projectRepository.findAll()).thenReturn(new ArrayList<>());
    
    final ProjectService service = createService();
    
    final List<ProjectDetails> actual = service.getProjects();
    assertThat(actual).isNotNull().hasSize(0);
  }
  
  private ProjectService createService() {
    return new ProjectServiceImpl(projectRepository, projectDetailsRepository);
  }
}

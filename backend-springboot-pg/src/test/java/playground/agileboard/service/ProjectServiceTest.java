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
import playground.agileboard.model.Project;
import playground.agileboard.repository.ProjectRepository;

public class ProjectServiceTest {
  private static final Project PROJECT_1 = new Project(1, "XYZ", "Project XYZ", "Lorem Ipsum XYZ",
      Instant.parse("2018-01-01T00:00:00.00Z"), Instant.parse("2022-01-01T00:00:00.00Z"), 1);
  private static final Project PROJECT_2 = new Project(2, "ABC", "Project ABC", "Lorem Ipsum ABC",
          Instant.parse("2019-01-01T00:00:00.00Z"), Instant.parse("2023-01-01T00:00:00.00Z"), 1);
  
 
  private ProjectRepository projectRepository;

  @Before
  public void setup() {
    this.projectRepository = mock(ProjectRepository.class);
  }

  @Test
  public void getProject_2_projects() {
    when(projectRepository.findAll()).thenReturn(Arrays.asList(PROJECT_1, PROJECT_2));
    
    final ProjectService service = new ProjectServiceImpl(projectRepository);
    
    final List<Project> actual = service.getProjects();
    assertThat(actual).isNotNull().hasSize(2).containsExactlyInAnyOrder(PROJECT_1, PROJECT_2);
  }
  
  @Test
  public void getProject_1_project() {
    when(projectRepository.findAll()).thenReturn(Arrays.asList(PROJECT_1));
    
    final ProjectService service = new ProjectServiceImpl(projectRepository);
    
    final List<Project> actual = service.getProjects();
    assertThat(actual).isNotNull().hasSize(1).contains(PROJECT_1);
  }
  
  @Test
  public void getProject_0_projects() {
    when(projectRepository.findAll()).thenReturn(new ArrayList<>());
    
    final ProjectService service = new ProjectServiceImpl(projectRepository);
    
    final List<Project> actual = service.getProjects();
    assertThat(actual).isNotNull().hasSize(0);
  }
}

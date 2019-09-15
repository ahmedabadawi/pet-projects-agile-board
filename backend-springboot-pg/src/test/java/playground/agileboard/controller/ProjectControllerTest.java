package playground.agileboard.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import playground.agileboard.model.ProjectDetails;
import playground.agileboard.service.ProjectService;

@RunWith(SpringRunner.class)
@WebMvcTest(ProjectController.class)
public class ProjectControllerTest {
  final String ADMIN_EMAIL = "admin@corp.com";
  final String ADMIN_FIRST_NAME = "John";
  final String ADMIN_LAST_NAME  = "Doe";
  
  final ProjectDetails PROJECT_1 = new ProjectDetails(1, "XYZ", "Project XYZ", "Lorem Ipsum XYZ",
      Instant.parse("2018-01-01T00:00:00.00Z"), Instant.parse("2022-01-01T00:00:00.00Z"), 1,
      ADMIN_EMAIL, ADMIN_FIRST_NAME, ADMIN_LAST_NAME);
  final ProjectDetails PROJECT_2 = new ProjectDetails(2, "ABC", "Project ABC", "Lorem Ipsum ABC",
      Instant.parse("2019-01-01T00:00:00.00Z"), Instant.parse("2023-01-01T00:00:00.00Z"), 1,
      ADMIN_EMAIL, ADMIN_FIRST_NAME, ADMIN_LAST_NAME);
  
  @Autowired
  private MockMvc mvc;

  @MockBean
  private ProjectService projectService;

  @WithMockUser(value = ADMIN_EMAIL, authorities = "USER")
  @Test
  public void getProjects_1_project_sucess() throws Exception {
    
    when(projectService.getProjects()).thenReturn(Collections.singletonList(PROJECT_1));


    mvc.perform(get("/api/projects").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(jsonPath("$.total", equalTo(1))).andExpect(jsonPath("$.projects", hasSize(1)))
        .andExpect(jsonPath("$.projects[0].projectId", equalTo(PROJECT_1.getProjectId())))
        .andExpect(jsonPath("$.projects[0].code", equalTo(PROJECT_1.getCode())))
        .andExpect(jsonPath("$.projects[0].title", equalTo(PROJECT_1.getTitle())))
        .andExpect(jsonPath("$.projects[0].description", equalTo(PROJECT_1.getDescription())))
        .andExpect(jsonPath("$.projects[0].startDate", equalTo(PROJECT_1.getStartDate().toString())))
        .andExpect(jsonPath("$.projects[0].endDate", equalTo(PROJECT_1.getEndDate().toString())))
        .andExpect(jsonPath("$.projects[0].adminId", equalTo(PROJECT_1.getAdminId())))
        .andExpect(jsonPath("$.projects[0].adminEmail", equalTo(PROJECT_1.getAdminEmail())))
        .andExpect(jsonPath("$.projects[0].adminFirstName", equalTo(PROJECT_1.getAdminFirstName())))
        .andExpect(jsonPath("$.projects[0].adminLastName", equalTo(PROJECT_1.getAdminLastName())));
  }

  @WithMockUser(value = ADMIN_EMAIL, authorities = "USER")
  @Test
  public void getProjects_2_projects_sucess() throws Exception {
    final List<ProjectDetails> testProjects = Arrays.asList(PROJECT_1, PROJECT_2);
    when(projectService.getProjects()).thenReturn(testProjects);


    mvc.perform(get("/api/projects").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(jsonPath("$.total", equalTo(2))).andExpect(jsonPath("$.projects", hasSize(2)));
  }
  
  @WithMockUser(value = ADMIN_EMAIL, authorities = "USER")
  @Test
  public void getProjects_0_projects_sucess() throws Exception {
    when(projectService.getProjects()).thenReturn(new ArrayList<>());


    mvc.perform(get("/api/projects").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(jsonPath("$.total", equalTo(0))).andExpect(jsonPath("$.projects", hasSize(0)));
  }
  
  @WithMockUser(value = "guest@corp.com", authorities = "GUEST")
  @Test
  public void getProjects_noPermission_failUnauthorized() throws Exception {
    when(projectService.getProjects()).thenReturn(new ArrayList<>());


    mvc.perform(get("/api/projects").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isForbidden());
  }
}

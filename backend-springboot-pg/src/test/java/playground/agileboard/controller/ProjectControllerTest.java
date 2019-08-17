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
import playground.agileboard.model.Project;
import playground.agileboard.service.ProjectService;

@RunWith(SpringRunner.class)
@WebMvcTest(ProjectController.class)
public class ProjectControllerTest {
  @Autowired
  private MockMvc mvc;

  @MockBean
  private ProjectService projectService;

  @WithMockUser(value = "admin@corp.com", authorities = "USER")
  @Test
  public void getProjects_1_project_sucess() throws Exception {
    final Project testProject = new Project(1, "XYZ", "Project XYZ", "Lorem Ipsum XYZ",
        Instant.parse("2018-01-01T00:00:00.00Z"), Instant.parse("2022-01-01T00:00:00.00Z"), 1);
    when(projectService.getProjects()).thenReturn(Collections.singletonList(testProject));


    mvc.perform(get("/api/projects").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(jsonPath("$.total", equalTo(1))).andExpect(jsonPath("$.projects", hasSize(1)))
        .andExpect(jsonPath("$.projects[0].id", equalTo(testProject.getId())))
        .andExpect(jsonPath("$.projects[0].code", equalTo(testProject.getCode())))
        .andExpect(jsonPath("$.projects[0].title", equalTo(testProject.getTitle())))
        .andExpect(jsonPath("$.projects[0].description", equalTo(testProject.getDescription())))
        .andExpect(jsonPath("$.projects[0].startDate", equalTo(testProject.getStartDate().toString())))
        .andExpect(jsonPath("$.projects[0].endDate", equalTo(testProject.getEndDate().toString())))
        .andExpect(jsonPath("$.projects[0].adminId", equalTo(testProject.getAdminId())));
  }

  @WithMockUser(value = "admin@corp.com", authorities = "USER")
  @Test
  public void getProjects_2_projects_sucess() throws Exception {
    final List<Project> testProjects = Arrays.asList(
        new Project(1, "XYZ", "Project XYZ", "Lorem Ipsum XYZ",
        Instant.parse("2018-01-01T00:00:00.00Z"), Instant.parse("2022-01-01T00:00:00.00Z"), 1),
        new Project(2, "ABC", "Project ABC", "Lorem Ipsum ABC",
            Instant.parse("2019-01-01T00:00:00.00Z"), Instant.parse("2023-01-01T00:00:00.00Z"), 1));
    when(projectService.getProjects()).thenReturn(testProjects);


    mvc.perform(get("/api/projects").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(jsonPath("$.total", equalTo(2))).andExpect(jsonPath("$.projects", hasSize(2)));
  }
  
  @WithMockUser(value = "admin@corp.com", authorities = "USER")
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

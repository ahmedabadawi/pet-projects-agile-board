package playground.agileboard.controller;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import playground.agileboard.controller.dto.ProjectDetails;
import playground.agileboard.controller.dto.ProjectsList;
import playground.agileboard.service.ProjectService;

@RestController
public class ProjectController {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProjectController.class);

  private static final String MIME_APPLICATION_JSON = "application/json";

  private final ProjectService projectService;

  @Autowired
  public ProjectController(final ProjectService projectService) {
    this.projectService = projectService;
  }

  @RequestMapping(value = "/api/projects", method = RequestMethod.GET,
      produces = MIME_APPLICATION_JSON)
  @PreAuthorize("hasAuthority('USER')")
  public ResponseEntity<?> getProjects(final Principal currentPrincipal) {
    LOGGER.debug("Current Principal: {}", currentPrincipal.getName());

    try {
      final List<ProjectDetails> projects = projectService.getProjects().stream().map(ProjectDetails::fromModel)
          .collect(Collectors.toList());
      final ProjectsList result = new ProjectsList(projects);

      return ResponseEntity.ok(result);
    } catch (RuntimeException e) {
      LOGGER.error(e.getMessage(), e);
      return ResponseEntity.status(500).body(null);
    }
  }
}

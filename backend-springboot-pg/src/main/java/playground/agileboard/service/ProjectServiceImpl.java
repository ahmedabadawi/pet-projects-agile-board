package playground.agileboard.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import playground.agileboard.model.Project;
import playground.agileboard.repository.ProjectRepository;

public class ProjectServiceImpl implements ProjectService {
  private static final Logger LOG = LoggerFactory.getLogger(ProjectServiceImpl.class);
  
  private final ProjectRepository projectRepository;

  @Autowired
  public ProjectServiceImpl(final ProjectRepository projectRepository) {
    this.projectRepository = projectRepository;
  }
  
  @Override
  public List<Project> getProjects() {
    // TODO: Update this to be get projects by member
    final List<Project> projects = new ArrayList<>();
    projectRepository.findAll().forEach(projects::add);
    
    LOG.debug("Retrieved {} Projects", projects.size());
    
    return projects;
  }
}

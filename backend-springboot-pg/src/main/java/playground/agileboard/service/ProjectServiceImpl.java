package playground.agileboard.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import playground.agileboard.model.Project;
import playground.agileboard.model.ProjectDetails;
import playground.agileboard.repository.ProjectDetailsRepository;
import playground.agileboard.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {
  private static final Logger LOG = LoggerFactory.getLogger(ProjectServiceImpl.class);
  
  private final ProjectRepository projectRepository;
  private final ProjectDetailsRepository projectDetailsRepository;
  
  @Autowired
  public ProjectServiceImpl(final ProjectRepository projectRepository, 
                            final ProjectDetailsRepository projectDetailsRepository) {
    this.projectRepository = projectRepository;
    this.projectDetailsRepository = projectDetailsRepository;
  }
  
  @Override
  public List<ProjectDetails> getProjects() {
    // TODO: Update this to be get projects by member
    final List<ProjectDetails> projects = new ArrayList<>();
    projectDetailsRepository.findAll().forEach(projects::add);
    
    LOG.debug("Retrieved {} Projects", projects.size());
    
    return projects;
  }
  
  @Override
  public Project createProject(Project project) {
    return projectRepository.save(project);
  }
}

package playground.agileboard.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import playground.agileboard.repository.ProjectRepository;
import playground.agileboard.service.ProjectService;
import playground.agileboard.service.ProjectServiceImpl;

@Configuration
public class ApplicationConfiguration {

  @Autowired
  private ProjectRepository projectRepository;
  
  
  @Bean
  public ProjectService projectService() {
    return new ProjectServiceImpl(projectRepository);
  }
}

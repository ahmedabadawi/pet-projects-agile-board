package playground.agileboard.service;

import java.util.List;
import org.springframework.stereotype.Service;
import playground.agileboard.model.Project;
import playground.agileboard.model.ProjectDetails;

@Service
public interface ProjectService {

  List<ProjectDetails> getProjects();
  
  Project createProject(Project project);
}

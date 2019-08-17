package playground.agileboard.service;

import java.util.List;
import org.springframework.stereotype.Service;
import playground.agileboard.model.Project;

@Service
public interface ProjectService {

  List<Project> getProjects();

}

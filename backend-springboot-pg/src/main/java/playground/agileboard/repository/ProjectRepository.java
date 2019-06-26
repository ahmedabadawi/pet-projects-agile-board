package playground.agileboard.repository;

import org.springframework.data.repository.CrudRepository;
import playground.agileboard.model.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer> {}

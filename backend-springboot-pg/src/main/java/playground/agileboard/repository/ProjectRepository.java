package playground.agileboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import playground.agileboard.model.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Integer> {}

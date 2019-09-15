package playground.agileboard.repository;

import org.springframework.stereotype.Repository;
import playground.agileboard.model.ProjectDetails;

@Repository
public interface ProjectDetailsRepository extends org.springframework.data.repository.Repository<ProjectDetails, Integer> {
  Iterable<ProjectDetails> findAll();
}

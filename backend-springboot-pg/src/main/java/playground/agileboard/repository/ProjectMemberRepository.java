package playground.agileboard.repository;

import org.springframework.data.repository.CrudRepository;
import playground.agileboard.model.ProjectMember;

public interface ProjectMemberRepository extends CrudRepository<ProjectMember, Integer> {}

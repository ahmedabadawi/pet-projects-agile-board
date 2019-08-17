package playground.agileboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import playground.agileboard.model.ProjectMember;

@Repository
public interface ProjectMemberRepository extends CrudRepository<ProjectMember, Integer> {}

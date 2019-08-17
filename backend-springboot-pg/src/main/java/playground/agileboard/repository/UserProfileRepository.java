package playground.agileboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import playground.agileboard.model.UserProfile;

@Repository
public interface UserProfileRepository extends CrudRepository<UserProfile, Integer> {}

package playground.agileboard.repository;

import org.springframework.data.repository.CrudRepository;
import playground.agileboard.model.UserProfile;

public interface UserProfileRepository extends CrudRepository<UserProfile, Integer> {}

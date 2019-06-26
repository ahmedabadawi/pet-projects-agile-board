package playground.agileboard.repository;

import org.springframework.data.repository.CrudRepository;
import playground.agileboard.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {}

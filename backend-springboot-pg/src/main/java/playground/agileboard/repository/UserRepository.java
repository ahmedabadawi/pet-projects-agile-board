package playground.agileboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import playground.agileboard.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {}

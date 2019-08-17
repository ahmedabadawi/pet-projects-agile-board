package playground.agileboard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import playground.agileboard.model.LoginUser;

@Repository
public interface AuthRepository extends CrudRepository<LoginUser, String> {}

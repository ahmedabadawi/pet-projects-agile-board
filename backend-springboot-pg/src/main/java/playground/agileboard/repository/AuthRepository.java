package playground.agileboard.repository;

import org.springframework.data.repository.CrudRepository;
import playground.agileboard.model.LoginUser;

public interface AuthRepository extends CrudRepository<LoginUser, String> {}

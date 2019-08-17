package playground.agileboard.service;

import java.util.List;
import org.springframework.stereotype.Service;
import playground.agileboard.model.User;

@Service
public interface AdminService {

  List<User> getUsers();

  void createUser(User user);

}

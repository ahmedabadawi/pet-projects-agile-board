package playground.agileboard.repository;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import playground.agileboard.model.LoginUser;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AuthRepositoryTest {
  @Autowired
  private TestEntityManager entityManager;
  
  @Autowired
  private AuthRepository repository;
  
  @Test
  public void findByEmail_exists() {
    final String email = "admin@corp.com";
    final String passwordHash = "ABCDEF0123456789";
    final Integer userId = 999;
    final String roles = "ADMIN,USER";
    final LoginUser testUser = new LoginUser(email, passwordHash, userId, roles);
    entityManager.persist(testUser);
    entityManager.flush();
    
    final Optional<LoginUser> actual = repository.findById(email);
    assertThat(actual).isPresent().hasValue(testUser);
  }
  
  @Test
  public void findByEmail_notExist() {
    final String email = "admin@corp.com";
    final Optional<LoginUser> actual = repository.findById(email);
    assertThat(actual).isNotPresent();
  }
}

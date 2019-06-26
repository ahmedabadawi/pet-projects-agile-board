package playground.agileboard.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AuthUser")
public class LoginUser {
  @Id
  private String email;
  private String passwordHash;
  private Integer userId;
  
  public LoginUser() {}
  
  
  public LoginUser(String email, String passwordHash, Integer userId) {
  
    this.email = email;
    this.passwordHash = passwordHash;
    this.userId = userId;
  }

  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPasswordHash() {
    return passwordHash;
  }
  public void setPasswordHash(String passwordHash) {
    this.passwordHash = passwordHash;
  }
  public Integer getUserId() {
    return userId;
  }
  public void setUserId(Integer userId) {
    this.userId = userId;
  }
}

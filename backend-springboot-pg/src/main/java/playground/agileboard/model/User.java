package playground.agileboard.model;

import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AppUser")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  private String email;
  private String firstName;
  private String lastName;
  private String status;
  private Instant lastLogin;

  public User () {}
  
  
  public User(Integer id, String email, String firstName, String lastName, String status,
      Instant lastLogin) {
  
    this.id = id;
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
    this.status = status;
    this.lastLogin = lastLogin;
  }

  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }
  public Instant getLastLogin() {
    return lastLogin;
  }
  public void setLastLogin(Instant lastLogin) {
    this.lastLogin = lastLogin;
  }
}

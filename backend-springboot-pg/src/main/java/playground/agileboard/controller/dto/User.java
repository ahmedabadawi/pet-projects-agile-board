package playground.agileboard.controller.dto;

import java.time.Instant;

public class User {
  private Integer id;
  private String firstName;
  private String lastName;
  private String email;
  private String status;
  private Instant lastLogin;
  
  public User() {}

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

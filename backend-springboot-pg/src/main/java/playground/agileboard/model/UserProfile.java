package playground.agileboard.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserProfile {
  @Id
  private Integer userId;
  
  private String email;
  
  private String firstName;
  private String lastName;
  
  private String photo;
  private String bio;
  
  public UserProfile() {}
  
  
  public UserProfile(Integer userId, String email, String firstName, String lastName, String photo,
      String bio) {

    this.userId = userId;
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
    this.photo = photo;
    this.bio = bio;
  }

  public Integer getUserId() {
    return userId;
  }
  public void setUserId(Integer userId) {
    this.userId = userId;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
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
  public String getPhoto() {
    return photo;
  }
  public void setPhoto(String photo) {
    this.photo = photo;
  }
  public String getBio() {
    return bio;
  }
  public void setBio(String bio) {
    this.bio = bio;
  }
}

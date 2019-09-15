package playground.agileboard.model;

import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProjectDetails {

  @Id
  private Integer projectId;
  
  private String code;
  private String title;
  private String description;
  private Instant startDate;
  private Instant endDate;
  
  private Integer adminId;
  private String adminEmail;
  private String adminFirstName;
  private String adminLastName;

  public ProjectDetails() {}

  
  public ProjectDetails(Integer projectId, String code, String title, String description,
      Instant startDate, Instant endDate, Integer adminId, String adminEmail, String adminFirstName,
      String adminLastName) {
  
    this.projectId = projectId;
    this.code = code;
    this.title = title;
    this.description = description;
    this.startDate = startDate;
    this.endDate = endDate;
    this.adminId = adminId;
    this.adminEmail = adminEmail;
    this.adminFirstName = adminFirstName;
    this.adminLastName = adminLastName;
  }

  public Integer getProjectId() {
    return projectId;
  }

  public void setProjectId(Integer projectId) {
    this.projectId = projectId;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Instant getStartDate() {
    return startDate;
  }

  public void setStartDate(Instant startDate) {
    this.startDate = startDate;
  }

  public Instant getEndDate() {
    return endDate;
  }

  public void setEndDate(Instant endDate) {
    this.endDate = endDate;
  }

  public Integer getAdminId() {
    return adminId;
  }

  public void setAdminId(Integer adminId) {
    this.adminId = adminId;
  }

  public String getAdminEmail() {
    return adminEmail;
  }

  public void setAdminEmail(String adminEmail) {
    this.adminEmail = adminEmail;
  }

  public String getAdminFirstName() {
    return adminFirstName;
  }

  public void setAdminFirstName(String adminFirstName) {
    this.adminFirstName = adminFirstName;
  }

  public String getAdminLastName() {
    return adminLastName;
  }

  public void setAdminLastName(String adminLastName) {
    this.adminLastName = adminLastName;
  }
}

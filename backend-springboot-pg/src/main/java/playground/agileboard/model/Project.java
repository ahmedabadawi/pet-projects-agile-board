package playground.agileboard.model;

import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Project {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  private String code;
  private String title;
  private String description;
  private Instant startDate;
  private Instant endDate;
  private Integer adminId;
  
  public Project() {}
  
  
  public Project(Integer id, String code, String title, String description, Instant startDate,
      Instant endDate, Integer adminId) {
  
    this.id = id;
    this.code = code;
    this.title = title;
    this.description = description;
    this.startDate = startDate;
    this.endDate = endDate;
    this.adminId = adminId;
  }

  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
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
}

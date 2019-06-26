package playground.agileboard.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WorkItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  private Integer projectId;
  private String projectCode;
  
  private String title;
  private String description;
  private String stereotype;
  private String status;
  
  public WorkItem() {}
  
  
  public WorkItem(Integer id, Integer projectId, String projectCode, String title,
      String description, String stereotype, String status) {

    this.id = id;
    this.projectId = projectId;
    this.projectCode = projectCode;
    this.title = title;
    this.description = description;
    this.stereotype = stereotype;
    this.status = status;
  }

  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public Integer getProjectId() {
    return projectId;
  }
  public void setProjectId(Integer projectId) {
    this.projectId = projectId;
  }
  public String getProjectCode() {
    return projectCode;
  }
  public void setProjectCode(String projectCode) {
    this.projectCode = projectCode;
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
  public String getStereotype() {
    return stereotype;
  }
  public void setStereotype(String stereotype) {
    this.stereotype = stereotype;
  }
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }
}

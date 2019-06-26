package playground.agileboard.controller.dto;

public class WorkItem {
  private Integer id;
  private Integer projectId;
  private String projectCode;
  // EPIC, STORY, TASK, BUG
  private String stereotype;
  private String title;
  private String description;
  // NOT_STARTED, IN_PROGRESS, BLOCKED, DONE
  private String status;
  
  public WorkItem() {}

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

  public String getStereotype() {
    return stereotype;
  }

  public void setStereotype(String stereotype) {
    this.stereotype = stereotype;
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

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}

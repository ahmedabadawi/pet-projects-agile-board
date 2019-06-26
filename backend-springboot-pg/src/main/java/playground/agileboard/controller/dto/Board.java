package playground.agileboard.controller.dto;

import java.util.List;

public class Board {
  private Integer projectId;
  private String projectCode;
  private List<WorkItem> items;
  
  public Board() {}

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

  public List<WorkItem> getItems() {
    return items;
  }

  public void setItems(List<WorkItem> items) {
    this.items = items;
  }
}

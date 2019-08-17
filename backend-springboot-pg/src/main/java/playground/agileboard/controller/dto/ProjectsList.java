package playground.agileboard.controller.dto;

import java.util.List;

public class ProjectsList {
  private Integer total;
  private List<Project> projects;
  
  public ProjectsList() {}
  
  public ProjectsList(final List<Project> projects) {
    this.projects = projects;
    this.total = projects.size();
  }
  
  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public List<Project> getProjects() {
    return projects;
  }

  public void setProjects(List<Project> projects) {
    this.projects = projects;
  }
}

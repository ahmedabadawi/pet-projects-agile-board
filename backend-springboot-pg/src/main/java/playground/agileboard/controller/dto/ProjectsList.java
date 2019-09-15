package playground.agileboard.controller.dto;

import java.util.List;

public class ProjectsList {
  private Integer total;
  private List<ProjectDetails> projects;
  
  public ProjectsList() {}
  
  public ProjectsList(final List<ProjectDetails> projects) {
    this.projects = projects;
    this.total = projects.size();
  }
  
  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public List<ProjectDetails> getProjects() {
    return projects;
  }

  public void setProjects(List<ProjectDetails> projects) {
    this.projects = projects;
  }
}

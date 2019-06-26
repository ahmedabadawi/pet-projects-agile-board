package playground.agileboard.controller.dto;

import java.util.List;

public class ProjectMembersList {
  private Integer total;
  private List<ProjectMember> members;
  
  public ProjectMembersList() {}

  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public List<ProjectMember> getMembers() {
    return members;
  }

  public void setMembers(List<ProjectMember> members) {
    this.members = members;
  }
}

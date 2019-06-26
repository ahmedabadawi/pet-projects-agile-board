package playground.agileboard.controller.dto;

import java.util.List;

public class UsersList {
  private Integer total;
  private List<User> users;
  
  public UsersList() {}

  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }
}

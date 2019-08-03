package playground.agileboard.controller.dto;

public class AuthToken {
  private Integer userId;
  private String token;
  
  public AuthToken() {}

  public AuthToken(final Integer userId, final String token) {
    this.userId = userId;
    this.token = token;
  }


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getToken() {
    return token;
  }

  public void setToken(final String token) {
    this.token = token;
  }
  
  public static AuthToken fromModel(playground.agileboard.model.AuthToken model) {
    if (model == null) {
      throw new IllegalArgumentException("model");
    }
    
    final AuthToken dto = new AuthToken();
    dto.setUserId(model.getUserId());
    dto.setToken(model.getToken());
    return dto;
  }
}

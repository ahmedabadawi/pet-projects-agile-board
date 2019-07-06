package playground.agileboard.controller.dto;

import java.time.Instant;

public class AuthToken {
  private Integer userId;
  private String token;
  private Instant expiresAt;
  
  public AuthToken() {}

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

  public Instant getExpiresAt() {
    return expiresAt;
  }

  public void setExpiresAt(final Instant expiresAt) {
    this.expiresAt = expiresAt;
  }
  
  public static AuthToken fromModel(playground.agileboard.model.AuthToken model) {
    if (model == null) {
      throw new IllegalArgumentException("model");
    }
    
    final AuthToken dto = new AuthToken();
    dto.setUserId(model.getUserId());
    dto.setToken(model.getToken());
    dto.setExpiresAt(model.getExpiresAt());
    return dto;
  }
}

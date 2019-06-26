package playground.agileboard.model;

import java.time.Instant;

public class AuthToken {
  private Integer userId;
  private String token;
  private Instant expiresAt;
  
  public AuthToken() {}
  
  public AuthToken(Integer userId, String token, Instant expiresAt) {
    this.userId = userId;
    this.token = token;
    this.expiresAt = expiresAt;
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

  public void setToken(String token) {
    this.token = token;
  }

  public Instant getExpiresAt() {
    return expiresAt;
  }

  public void setExpiresAt(Instant expiresAt) {
    this.expiresAt = expiresAt;
  }
}

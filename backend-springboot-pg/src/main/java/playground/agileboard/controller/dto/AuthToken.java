package playground.agileboard.controller.dto;

import java.time.Instant;

public class AuthToken {
  private String token;
  private Instant expiresAt;
  
  public AuthToken() {}

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
    dto.setToken(model.getToken());
    dto.setExpiresAt(model.getExpiresAt());
    return dto;
  }
}

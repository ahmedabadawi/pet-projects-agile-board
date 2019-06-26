package playground.agileboard;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Primary
@Configuration
@ConfigurationProperties(prefix = "app")
public class AppConfig {
  private AuthConfig auth;
  
  public AppConfig() {}
  
  public AuthConfig getAuth() {
    return auth;
  }

  public void setAuth(AuthConfig auth) {
    this.auth = auth;
  }


  public static class AuthConfig {
    private String secret;
    private String issuer;
    private Integer expiry;
    
    public AuthConfig() {}

    public String getSecret() {
      return secret;
    }

    public void setSecret(String secret) {
      this.secret = secret;
    }

    public String getIssuer() {
      return issuer;
    }

    public void setIssuer(String issuer) {
      this.issuer = issuer;
    }
    
    public Integer getExpiry() {
      return expiry;
    }
    
    public void setExpiry(Integer expiry) {
      this.expiry = expiry;
    }
  }
}

package playground.agileboard.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

public class TokenBasedPrinciple extends AbstractAuthenticationToken {
  private final String token;
  private final UserDetails user;
  
  public TokenBasedPrinciple(final String token, final UserDetails user) {
    super(user.getAuthorities());
    this.user = user;
    this.token = token;
  }
  
  public String getToken() {
    return token;
  }  
  
  @Override
  public boolean isAuthenticated() {
    return true;
  }

  @Override
  public Object getCredentials() {
    return token;
  }

  @Override
  public UserDetails getPrincipal() {
    return user;
  }
}

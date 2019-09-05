package playground.agileboard.model;

import static org.springframework.util.StringUtils.isEmpty;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Table(name = "auth_user")
public class LoginUser implements UserDetails {
  @Id
  private String email;
  private String password;
  private Integer userId;
  private String roles;
  private UserStatus status;
  private Instant lastLogin;
  
  public LoginUser() {}

  public LoginUser(final String email, final String password, final Integer userId, final String roles, final UserStatus status) {
    this(email, password, userId, roles, status, null);
  }

  public LoginUser(final String email, final String password, final Integer userId, final String roles, final UserStatus status, final Instant lastLogin) {

    this.email = email;
    this.password = password;
    this.userId = userId;
    this.roles = roles;
    this.status = status;
    this.lastLogin = lastLogin;
  }

  @Override
  public String getPassword() {
    return password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  public void setUsername(final String username) {
    this.email = username;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    if (!isEmpty(roles)) {
      return Arrays.stream(roles.split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    } 
    return new ArrayList<>();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }


  @Override
  public boolean isAccountNonLocked() {
    return true;
  }


  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }


  @Override
  public boolean isEnabled() {
    return true;
  }


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }
  
  public String getRoles() {
    return roles;
  }
  
  public void setRoles(final String roles) {
    this.roles = roles;
  }
  
  
  public UserStatus getStatus() {
    return status;
  }

  public void setStatus(final UserStatus status) {
    this.status = status;
  }

  public Instant getLastLogin() {
    return lastLogin;
  }

  public void setLastLogin(final Instant lastLogin) {
    this.lastLogin = lastLogin;
  }


  public enum UserStatus {
    ACTIVE,
    INACTIVE
  }
}

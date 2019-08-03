package playground.agileboard.model;

import static org.springframework.util.StringUtils.isEmpty;
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
@Table(name = "AuthUser")
public class LoginUser implements UserDetails {
  @Id
  private String username;
  private String password;
  private Integer userId;
  private String roles;
  
  public LoginUser() {}


  public LoginUser(final String username, final String password, final Integer userId, final String roles) {

    this.username = username;
    this.password = password;
    this.userId = userId;
    this.roles = roles;
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
    return username;
  }

  public void setUsername(final String username) {
    this.username = username;
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
}

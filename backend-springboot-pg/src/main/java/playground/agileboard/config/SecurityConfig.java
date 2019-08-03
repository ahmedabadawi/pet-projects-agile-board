package playground.agileboard.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import playground.agileboard.security.JwtDecoder;
import playground.agileboard.security.web.RestAuthenticationEntryPoint;
import playground.agileboard.security.web.TokenAuthenticationFilter;
import playground.agileboard.service.AuthService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  
  @Autowired
  private AuthService authService;
  
  
  
  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder authBuilder) throws Exception {
    authBuilder
      .userDetailsService(authService)
      .passwordEncoder(passwordEncoder());
  }
  
  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Autowired
  private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
  
  @Autowired
  private JwtDecoder jwtDecoder;
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      .and()
      .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint)
      .and()
      .authorizeRequests()
      .antMatchers(HttpMethod.POST, "/auth/login")
      .permitAll()
      .and()
      .authorizeRequests()
      .antMatchers(HttpMethod.GET, "/seed")    // TODO: find a smarter way of creating the first admin user
      .permitAll()
      .and()
      .authorizeRequests()
      .anyRequest().authenticated()
      .and()
      .authorizeRequests()
      .anyRequest().authenticated()
      .and()
      .addFilterBefore(new TokenAuthenticationFilter(jwtDecoder, authService), BasicAuthenticationFilter.class);
    http.csrf().disable();
  }
}

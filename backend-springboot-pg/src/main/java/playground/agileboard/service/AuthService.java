package playground.agileboard.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface AuthService extends UserDetailsService {

  UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}

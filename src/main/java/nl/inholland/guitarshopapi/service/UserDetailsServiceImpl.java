package nl.inholland.guitarshopapi.service;

import nl.inholland.guitarshopapi.dao.UserRepository;
import nl.inholland.guitarshopapi.model.SecurityUserDetails;
import nl.inholland.guitarshopapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username);
    return new SecurityUserDetails(user);
  }
}

package nl.inholland.guitarshopapi.service;

import nl.inholland.guitarshopapi.dao.UserRepository;
import nl.inholland.guitarshopapi.model.SecurityUserDetails;
import nl.inholland.guitarshopapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = Optional.ofNullable(userRepository.findByUsername(username))
        .orElseThrow(() -> new UsernameNotFoundException("user not found"));

    return new SecurityUserDetails(user);
  }
}

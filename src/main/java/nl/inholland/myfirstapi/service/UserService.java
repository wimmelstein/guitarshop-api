package nl.inholland.myfirstapi.service;

import nl.inholland.myfirstapi.model.User;
import nl.inholland.myfirstapi.model.dto.LoginDTO;
import nl.inholland.myfirstapi.repository.UserRepository;
import nl.inholland.myfirstapi.security.JwtTokenProvider;
import nl.inholland.myfirstapi.security.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserRepository userRepository;

    public String login(String username, String password) {
        try {
            manager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return jwtTokenProvider.createToken(username, userRepository.findUserByUsername(username).getRoles());
        } catch (AuthenticationException ae) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Invalid credentials");
        }
    }

    public String add(String username, String password) {
        System.out.println(String.format("User service: %s, %s", username, password));
        if (userRepository.findUserByUsername(username) == null) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(passwordEncoder().encode(password));
            user.setRoles(List.of(Role.ROLE_ADMIN, Role.ROLE_USER));
            userRepository.save(user);
            String token = jwtTokenProvider.createToken(user.getUsername(), user.getRoles());
            return token;
        } else {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Username already in use");
        }
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}

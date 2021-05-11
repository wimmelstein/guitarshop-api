package nl.inholland.myfirstapi.config;

import lombok.extern.java.Log;
import nl.inholland.myfirstapi.model.User;
import nl.inholland.myfirstapi.security.Role;
import nl.inholland.myfirstapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Log
@Component
public class GuitarshopApplicationRunner implements ApplicationRunner {

    @Autowired
    private UserService userService;
    @Override
    public void run(ApplicationArguments args) throws Exception {

        User user = new User();
        user.setUsername("testuser");
        user.setPassword("testpassword");
        user.setRoles(List.of(Role.ROLE_USER));
        String token = userService.add(user.getUsername(), user.getPassword(), List.of(Role.ROLE_USER));
        log.info("Token: " + token);

    }
}

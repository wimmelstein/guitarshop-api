package nl.inholland.myfirstapi.controller;

import nl.inholland.myfirstapi.model.User;
import nl.inholland.myfirstapi.model.dto.LoginDTO;
import nl.inholland.myfirstapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping(value = "/login")
    public String login(@RequestBody LoginDTO loginDTO) {
        System.out.println(loginDTO);
        return userService.login(loginDTO.getUsername(), loginDTO.getPassword());
    }

    @PostMapping(value = "/add")
    public ResponseEntity<String> addUser(@RequestBody LoginDTO loginDTO) {

        String token  = userService.add(loginDTO.getUsername(), loginDTO.getPassword(), new ArrayList<>());
        return ResponseEntity.ok(token);
    }


}

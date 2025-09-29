package com.practice.spring_security.controller;

import com.practice.spring_security.model.Userss;
import com.practice.spring_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Userss register(@RequestBody Userss user) {
        System.out.println("register request hit");
        return userService.saveUser(user);
    }
    @GetMapping("/greet")
    public String greet(@RequestParam String username) {
        Userss user = userService.findByUsername(username);
        return "Hello " + user.getName() +" Welcome to Spring Security";
    }
}

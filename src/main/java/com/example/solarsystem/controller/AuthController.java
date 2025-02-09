package com.example.solarsystem.controller;

import com.example.solarsystem.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username,
                               @RequestParam String email,
                               @RequestParam String password,
                               @RequestParam(defaultValue = "false") boolean isAdmin) {
        userService.registerUser(username, email, password, isAdmin);
        return "redirect:/login?registered";
    }

    // @PostMapping("/register")
    // public String registerUser(@RequestParam String username,
    //                          @RequestParam String email,
    //                          @RequestParam String password) {
    //     userService.registerUser(username, email, password, true);
    //     return "redirect:/login?registered";
    // }   
}
package com.example.solarsystem.controller;

import com.example.solarsystem.model.User;
import com.example.solarsystem.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    private final UserService userService;

    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showProfile(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        // Add user details to model
        return "profile";
    }

    @PostMapping("/update")
    public String updateProfile(@AuthenticationPrincipal UserDetails userDetails,
                              @RequestParam String firstName,
                              @RequestParam String lastName,
                              @RequestParam String favoritePlanet,
                              @RequestParam String bio) {
        // Update profile logic
        return "redirect:/profile?updated";
    }
}
package com.example.solarsystem.controller;

import com.example.solarsystem.model.*;
import com.example.solarsystem.service.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;
    private final UserService userService;
    private final PlanetService planetService;

    public AdminController(AdminService adminService, 
                         UserService userService,
                         PlanetService planetService) {
        this.adminService = adminService;
        this.userService = userService;
        this.planetService = planetService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("metrics", adminService.getDashboardMetrics());
        return "admin/dashboard";
    }

    @GetMapping("/users")
    public String userManagement(Model model) {
        model.addAttribute("users", adminService.getAllUsers());
        return "admin/users";
    }

    @PostMapping("/users/{userId}/toggle")
    @ResponseBody
    public boolean toggleUserStatus(@PathVariable Long userId) {
        return userService.toggleUserStatus(userId);
    }

    @GetMapping("/planets")
    public String planetManagement(Model model) {
        model.addAttribute("planets", planetService.getAllPlanets());
        return "admin/planets";
    }

    @PostMapping("/planets")
    public String updatePlanet(@ModelAttribute Planet planet, 
                             @AuthenticationPrincipal UserDetails userDetails) {
        // Assuming you have a method to get User from UserDetails
        User admin = userService.getUserByUsername(userDetails.getUsername());
        adminService.updatePlanet(planet, admin);
        return "redirect:/admin/planets";
    }

    @GetMapping("/logs")
    public String viewLogs(Model model) {
        // Add logic to fetch and display admin logs
        return "admin/logs";
    }
}
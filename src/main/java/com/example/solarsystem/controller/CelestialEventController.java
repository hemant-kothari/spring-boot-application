package com.example.solarsystem.controller;

import com.example.solarsystem.model.CelestialEvent;
import com.example.solarsystem.service.CelestialEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CelestialEventController {
    
    private final CelestialEventService eventService;
    
    @Autowired
    public CelestialEventController(CelestialEventService eventService) {
        this.eventService = eventService;
    }
    
    @GetMapping("/events")
    public String showEvents(Model model) {
        model.addAttribute("events", eventService.getUpcomingEvents());
        return "events";
    }
}
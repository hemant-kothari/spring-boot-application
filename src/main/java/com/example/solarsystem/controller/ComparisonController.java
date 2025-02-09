package com.example.solarsystem.controller;

import com.example.solarsystem.service.PlanetService;
import com.example.solarsystem.model.Planet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ComparisonController {

    private final PlanetService planetService;

    public ComparisonController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @GetMapping("/compare")
    public String showComparisonPage() {
        return "comparison";
    }

    @GetMapping("/api/compare")
    @ResponseBody
    public Map<String, Planet> comparePlanets(@RequestParam String planet1, @RequestParam String planet2) {
        Map<String, Planet> comparison = new HashMap<>();
        comparison.put("planet1", planetService.getPlanetDetails(planet1));
        comparison.put("planet2", planetService.getPlanetDetails(planet2));
        return comparison;
    }
}
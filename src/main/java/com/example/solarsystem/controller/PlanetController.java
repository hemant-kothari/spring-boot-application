package com.example.solarsystem.controller;

import com.example.solarsystem.model.Planet;
import com.example.solarsystem.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PlanetController {

    private final PlanetService planetService;

    @Autowired
    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/planets")
    public String showPlanets() {
        return "planets";
    }

    @GetMapping("/planet/{name}")
    @ResponseBody
    public ResponseEntity<Planet> getPlanetDetails(@PathVariable String name) {
        Planet planet = planetService.getPlanetDetails(name);
        if (planet != null) {
            return ResponseEntity.ok(planet);
        }
        return ResponseEntity.notFound().build();
    }
}




// package com.example.solarsystem.controller;

// import com.example.solarsystem.model.Planet;
// import com.example.solarsystem.service.PlanetService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.ResponseBody;

// @Controller
// public class PlanetController {

//     private final PlanetService planetService;

//     @Autowired
//     public PlanetController(PlanetService planetService) {
//         this.planetService = planetService;
//     }

//     @GetMapping("/")
//     public String home() {
//         return "index";
//     }

//     @GetMapping("/planet/{name}")
//     @ResponseBody
//     public ResponseEntity<Planet> getPlanetDetails(@PathVariable String name) {
//         Planet planet = planetService.getPlanetDetails(name);
//         if (planet != null) {
//             return ResponseEntity.ok(planet);
//         }
//         return ResponseEntity.notFound().build();
//     }
// }












// package com.example.solarsystem.controller;

// import com.example.solarsystem.model.Planet;
// import com.example.solarsystem.service.PlanetService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;

// @Controller
// public class PlanetController {
//     @Autowired
//     private PlanetService planetService;

//     @GetMapping("/")
//     public String home() {
//         return "index";
//     }

//     @GetMapping("/planet/{name}")
//     public String getPlanetDetails(@PathVariable String name, Model model) {
//         Planet planet = planetService.getPlanetDetails(name);
//         if (planet == null) {
//             System.out.println("Planet not found: " + name);
//             return "error";
//         }
//         model.addAttribute("planet", planet);
//         System.out.println("Planet details fetched successfully for: " + name);
//         return "planet";
//     }
// }












// package com.example.solarsystem.controller;

// import com.example.solarsystem.model.Planet;
// import com.example.solarsystem.service.PlanetService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.ResponseBody;

// @Controller
// public class PlanetController {

//     @Autowired
//     private PlanetService planetService;

//     @GetMapping("/")
//     public String home() {
//         return "index";
//     }

//     @GetMapping("/planet/{name}")
//     @ResponseBody
//     public Planet getPlanetDetails(@PathVariable String name) {
//         return planetService.getPlanetDetails(name);
//     }
// }
package com.example.solarsystem.service;

import com.example.solarsystem.model.Planet;
import com.example.solarsystem.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanetService {
    
    private final PlanetRepository planetRepository;
    
    @Autowired
    public PlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }
    
    public Planet getPlanetDetails(String name) {
        return planetRepository.findByName(name);
    }

    public Object getAllPlanets() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllPlanets'");
    }
}




// package com.example.solarsystem.service;

// import com.example.solarsystem.model.Planet;
// import org.springframework.stereotype.Service;

// @Service
// public class PlanetService {
//     public Planet getPlanetDetails(String name) {
//         System.out.println("Fetching planet details for: " + name);
//         return com.example.solarsystem.repository.PlanetRepository.findByName(name);
//     }
// }



// package com.example.solarsystem.service;

// import com.example.solarsystem.model.Planet;
// import com.example.solarsystem.repository.PlanetRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// @Service
// public class PlanetService {
    
//     @Autowired
//     private PlanetRepository PlanetRepository;
    
//     public Planet getPlanetDetails(String name) {
//         return PlanetRepository.findByName(name);
//     }
// }
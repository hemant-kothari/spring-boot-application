package com.example.solarsystem.repository;

import com.example.solarsystem.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {
    Planet findByName(String name);
}



// package com.example.solarsystem.repository;

// import com.example.solarsystem.model.Planet;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// @Repository
// public interface PlanetRepository extends JpaRepository<Planet, Long> {
//     static Planet findByName(String name) {
//         throw new UnsupportedOperationException("Unimplemented method 'findByName'");
//     } // No need for static or manual implementation
// }

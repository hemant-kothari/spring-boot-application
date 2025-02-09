package com.example.solarsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.Data;

@Data
@Entity
@Table(name = "planets")
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String description;
    
    @Column(name = "image_url")
    private String imageUrl;
    
    @Column(name = "distance_from_sun")
    private Double distanceFromSun;
    
    private Double diameter;
    
    @Column(name = "orbital_period")
    private Double orbitalPeriod;
    
    private Integer moons;
    private Double gravity;
    
    @Column(name = "atmosphere_composition")
    private String atmosphereComposition;
}



// package com.example.solarsystem.model;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
// import lombok.Data;

// @Data
// @Entity
// @Table(name = "planets")
// public class Planet {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private String name;
//     private String description;
//     private String imageUrl;
//     private Double distanceFormSun;
//     private Double diameter;
//     private Double orbitalPeriod;
//     private Integer moons;
//     private Double gravity;
//     private String atmosphereComposition;
// }
package com.example.solarsystem.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "celestial_events")
public class CelestialEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String description;
    
    @Column(name = "event_date")
    private LocalDateTime eventDate;
    
    @Column(name = "event_type")
    private String eventType; // e.g., "Eclipse", "Meteor Shower", "Conjunction"
    
    @Column(name = "visibility_location")
    private String visibilityLocation;
    
    private String duration;
    
    @Column(name = "image_url")
    private String imageUrl;
}
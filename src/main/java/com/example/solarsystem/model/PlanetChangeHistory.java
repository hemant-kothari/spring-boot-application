package com.example.solarsystem.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "planet_change_history")
public class PlanetChangeHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "planet_id")
    private Planet planet;

    @ManyToOne
    @JoinColumn(name = "changed_by")
    private User changedBy;

    @Column(name = "change_type")
    private String changeType; // CREATE, UPDATE, DELETE

    @Column(name = "changed_fields")
    private String changedFields;

    @Column(name = "old_values")
    private String oldValues;

    @Column(name = "new_values")
    private String newValues;

    @Column(name = "changed_at")
    private LocalDateTime changedAt = LocalDateTime.now();
}
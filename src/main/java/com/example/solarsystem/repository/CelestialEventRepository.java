package com.example.solarsystem.repository;

import com.example.solarsystem.model.CelestialEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface CelestialEventRepository extends JpaRepository<CelestialEvent, Long> {
    List<CelestialEvent> findByEventDateAfterOrderByEventDateAsc(LocalDateTime date);
    List<CelestialEvent> findByEventType(String eventType);
}
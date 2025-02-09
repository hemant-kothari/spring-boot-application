package com.example.solarsystem.repository;

import com.example.solarsystem.model.PlanetChangeHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PlanetChangeHistoryRepository extends JpaRepository<PlanetChangeHistory, Long> {
    List<PlanetChangeHistory> findByPlanetIdOrderByChangedAtDesc(Long planetId);
    List<PlanetChangeHistory> findByChangedByIdOrderByChangedAtDesc(Long userId);
}
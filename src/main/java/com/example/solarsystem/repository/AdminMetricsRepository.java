package com.example.solarsystem.repository;

import com.example.solarsystem.model.AdminMetrics;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface AdminMetricsRepository extends JpaRepository<AdminMetrics, Long> {
    List<AdminMetrics> findByMetricNameAndMetricDateBetween(String metricName, LocalDateTime start, LocalDateTime end);
}
package com.example.solarsystem.service;

import com.example.solarsystem.model.*;
import com.example.solarsystem.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
public class AdminService {
    private final AdminLogRepository adminLogRepository;
    private final PlanetChangeHistoryRepository changeHistoryRepository;
    private final AdminMetricsRepository metricsRepository;
    private final UserRepository userRepository;
    private final PlanetRepository planetRepository;

    public AdminService(AdminLogRepository adminLogRepository,
                       PlanetChangeHistoryRepository changeHistoryRepository,
                       AdminMetricsRepository metricsRepository,
                       UserRepository userRepository,
                       PlanetRepository planetRepository) {
        this.adminLogRepository = adminLogRepository;
        this.changeHistoryRepository = changeHistoryRepository;
        this.metricsRepository = metricsRepository;
        this.userRepository = userRepository;
        this.planetRepository = planetRepository;
    }

    @Transactional
    public void logAdminAction(User admin, String action, String entityType, Long entityId, String details) {
        AdminLog log = new AdminLog();
        log.setAdmin(admin);
        log.setAction(action);
        log.setEntityType(entityType);
        log.setEntityId(entityId);
        log.setDetails(details);
        adminLogRepository.save(log);
    }

    @Transactional
    public void recordPlanetChange(Planet planet, User admin, String changeType, 
                                 Map<String, String> oldValues, Map<String, String> newValues) {
        PlanetChangeHistory history = new PlanetChangeHistory();
        history.setPlanet(planet);
        history.setChangedBy(admin);
        history.setChangeType(changeType);
        history.setChangedFields(String.join(",", oldValues.keySet()));
        history.setOldValues(oldValues.toString());
        history.setNewValues(newValues.toString());
        changeHistoryRepository.save(history);
    }

    public Map<String, Object> getDashboardMetrics() {
        Map<String, Object> metrics = new HashMap<>();
        
        // User metrics
        metrics.put("totalUsers", userRepository.count());
        metrics.put("activeUsers", userRepository.countByEnabled(true));
        
        // Planet metrics
        metrics.put("totalPlanets", planetRepository.count());
        
        // Recent activity
        metrics.put("recentChanges", 
            changeHistoryRepository.findAll().stream()
                .limit(10)
                .toList());
        
        return metrics;
    }

    @Transactional
    public void updateMetrics() {
        LocalDateTime now = LocalDateTime.now();
        
        // Record user metrics
        recordMetric("TOTAL_USERS", userRepository.count(), now);
        recordMetric("ACTIVE_USERS", userRepository.countByEnabled(true), now);
        
        // Record planet metrics
        recordMetric("TOTAL_PLANETS", planetRepository.count(), now);
    }

    private void recordMetric(String name, long value, LocalDateTime date) {
        AdminMetrics metric = new AdminMetrics();
        metric.setMetricName(name);
        metric.setMetricValue(value);
        metric.setMetricDate(date);
        metricsRepository.save(metric);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public void updatePlanet(Planet planet, User admin) {
        Planet existingPlanet = planetRepository.findById(planet.getId())
            .orElseThrow(() -> new RuntimeException("Planet not found"));
        
        Map<String, String> oldValues = new HashMap<>();
        Map<String, String> newValues = new HashMap<>();
        
        // Compare and record changes
        if (!existingPlanet.getName().equals(planet.getName())) {
            oldValues.put("name", existingPlanet.getName());
            newValues.put("name", planet.getName());
        }
        // Add more field comparisons as needed
        
        planetRepository.save(planet);
        
        if (!oldValues.isEmpty()) {
            recordPlanetChange(planet, admin, "UPDATE", oldValues, newValues);
        }
    }
}
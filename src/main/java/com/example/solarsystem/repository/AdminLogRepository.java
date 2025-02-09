package com.example.solarsystem.repository;

import com.example.solarsystem.model.AdminLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface AdminLogRepository extends JpaRepository<AdminLog, Long> {
    List<AdminLog> findByCreatedAtBetweenOrderByCreatedAtDesc(LocalDateTime start, LocalDateTime end);
    List<AdminLog> findByAdminIdOrderByCreatedAtDesc(Long adminId);
}
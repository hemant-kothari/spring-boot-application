package com.example.solarsystem.repository;

import com.example.solarsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    long countByEnabled(boolean enabled);
    // Object countByEnabled(boolean b);
}

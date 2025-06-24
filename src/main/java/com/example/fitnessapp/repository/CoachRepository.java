package com.example.fitnessapp.repository;

import com.example.fitnessapp.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoachRepository extends JpaRepository<Coach, Long> {
    Optional<Coach> findByEmail(String email);
}

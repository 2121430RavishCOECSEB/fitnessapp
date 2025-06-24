package com.example.fitnessapp.repository;

import com.example.fitnessapp.model.DietPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DietPlanRepository extends JpaRepository<DietPlan, Long> {
    List<DietPlan> findByUserId(Long userId);
}

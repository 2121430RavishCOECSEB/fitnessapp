package com.example.fitnessapp.repository;

import com.example.fitnessapp.model.WorkoutPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlan, Long> {

    // Get all plans for a specific user
    List<WorkoutPlan> findByUserId(Long userId);

    // Get all plans created by a specific coach
    List<WorkoutPlan> findByCoachId(Long coachId);
}

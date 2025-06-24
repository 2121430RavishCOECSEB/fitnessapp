package com.example.fitnessapp.repository;

import com.example.fitnessapp.model.DietPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DietPlanRepository extends JpaRepository<DietPlan, Long> {
    List<DietPlan> findByUserId(Long userId);

    @Query("SELECT COALESCE(SUM(d.calories), 0) FROM DietPlan d")
    int sumAllCalories();

}


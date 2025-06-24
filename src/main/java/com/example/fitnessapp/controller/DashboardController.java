package com.example.fitnessapp.controller;

import com.example.fitnessapp.dto.DashboardMetrics;
import com.example.fitnessapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "*")
public class DashboardController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CoachRepository coachRepository;

    @Autowired
    private WorkoutPlanRepository workoutPlanRepository;

    @Autowired
    private DietPlanRepository dietPlanRepository;

    @GetMapping
    public DashboardMetrics getMetrics() {
        long totalUsers = userRepository.count();
        long totalCoaches = coachRepository.count();
        long totalWorkoutPlans = workoutPlanRepository.count();
        long totalDietPlans = dietPlanRepository.count();
        int totalCaloriesTracked = dietPlanRepository.sumAllCalories();

        return new DashboardMetrics(
                totalUsers, totalCoaches, totalWorkoutPlans, totalDietPlans, totalCaloriesTracked
        );
    }
}

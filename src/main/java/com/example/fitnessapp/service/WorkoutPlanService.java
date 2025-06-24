package com.example.fitnessapp.service;

import com.example.fitnessapp.exception.ResourceNotFoundException;
import com.example.fitnessapp.model.WorkoutPlan;
import com.example.fitnessapp.repository.WorkoutPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutPlanService {

    @Autowired
    private WorkoutPlanRepository workoutPlanRepository;

    // Create a new workout plan
    public WorkoutPlan createWorkoutPlan(WorkoutPlan workoutPlan) {
        return workoutPlanRepository.save(workoutPlan);
    }

    // Get all workout plans
    public List<WorkoutPlan> getAllWorkoutPlans() {
        return workoutPlanRepository.findAll();
    }

    // Get workout plans by user
    public List<WorkoutPlan> getPlansByUserId(Long userId) {
        return workoutPlanRepository.findByUserId(userId);
    }

    // Get workout plans by coach
    public List<WorkoutPlan> getPlansByCoachId(Long coachId) {
        return workoutPlanRepository.findByCoachId(coachId);
    }

    // Get single plan by ID
    public WorkoutPlan getPlanById(Long id) {
        return workoutPlanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Workout plan not found with id: " + id));
    }

    // Update existing workout plan
    public WorkoutPlan updateWorkoutPlan(Long id, WorkoutPlan updatedPlan) {
        WorkoutPlan plan = getPlanById(id);

        plan.setTitle(updatedPlan.getTitle());
        plan.setDescription(updatedPlan.getDescription());
        plan.setExercises(updatedPlan.getExercises());
        plan.setUserId(updatedPlan.getUserId());
        plan.setCoachId(updatedPlan.getCoachId());

        return workoutPlanRepository.save(plan);
    }
    
    
    public List<WorkoutPlan> getWorkoutPlansByUserId(Long userId) {
        return workoutPlanRepository.findByUserId(userId);
    }

    public WorkoutPlan getWorkoutPlanById(Long id) {
        return workoutPlanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Workout plan not found with id: " + id));
    }


    // Delete a workout plan
    public void deleteWorkoutPlan(Long id) {
        workoutPlanRepository.deleteById(id);
    }
}

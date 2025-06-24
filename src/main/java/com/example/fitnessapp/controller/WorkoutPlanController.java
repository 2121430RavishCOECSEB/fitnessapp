package com.example.fitnessapp.controller;

import com.example.fitnessapp.model.WorkoutPlan;
import com.example.fitnessapp.service.WorkoutPlanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workouts")
@CrossOrigin(origins = "*")
public class WorkoutPlanController {

    @Autowired
    private WorkoutPlanService workoutPlanService;

    // POST: Create a new workout plan
    @PostMapping
    public ResponseEntity<WorkoutPlan> createPlan(@Valid @RequestBody WorkoutPlan plan) {
        WorkoutPlan created = workoutPlanService.createWorkoutPlan(plan);
        return ResponseEntity.ok(created);
    }

    // GET: Get all workout plans
    @GetMapping
    public ResponseEntity<List<WorkoutPlan>> getAllPlans() {
        return ResponseEntity.ok(workoutPlanService.getAllWorkoutPlans());
    }

    // GET: Get workout plans for a user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<WorkoutPlan>> getPlansByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(workoutPlanService.getWorkoutPlansByUserId(userId));
    }

    // GET: Get workout plan by ID
    @GetMapping("/{id}")
    public ResponseEntity<WorkoutPlan> getPlanById(@PathVariable Long id) {
        return ResponseEntity.ok(workoutPlanService.getWorkoutPlanById(id));
    }

    // PUT: Update a workout plan
    @PutMapping("/{id}")
    public ResponseEntity<WorkoutPlan> updatePlan(@PathVariable Long id, @RequestBody WorkoutPlan plan) {
        WorkoutPlan updated = workoutPlanService.updateWorkoutPlan(id, plan);
        return ResponseEntity.ok(updated);
    }

    // DELETE: Delete a workout plan
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlan(@PathVariable Long id) {
        workoutPlanService.deleteWorkoutPlan(id);
        return ResponseEntity.ok("Workout plan deleted");
    }
}

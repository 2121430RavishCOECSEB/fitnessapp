package com.example.fitnessapp.controller;

import com.example.fitnessapp.model.DietPlan;
import com.example.fitnessapp.service.DietPlanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dietplans")
@CrossOrigin(origins = "*")
public class DietPlanController {

    @Autowired
    private DietPlanService dietPlanService;

    @PostMapping
    public DietPlan createDietPlan(@Valid @RequestBody DietPlan plan) {
        return dietPlanService.createDietPlan(plan);
    }

    @GetMapping
    public List<DietPlan> getAll() {
        return dietPlanService.getAllDietPlans();
    }

    @GetMapping("/{id}")
    public Optional<DietPlan> getDietPlanById(@PathVariable Long id) {
        return dietPlanService.getDietPlanById(id);
    }

    @GetMapping("/user/{userId}")
    public List<DietPlan> getByUserId(@PathVariable Long userId) {
        return dietPlanService.getDietPlansByUserId(userId);
    }

    @PutMapping("/{id}")
    public DietPlan updateDietPlan(@PathVariable Long id, @Valid @RequestBody DietPlan plan) {
        return dietPlanService.updateDietPlan(id, plan);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        dietPlanService.deleteDietPlan(id);
    }
}

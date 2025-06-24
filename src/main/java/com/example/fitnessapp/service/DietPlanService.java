package com.example.fitnessapp.service;

import com.example.fitnessapp.exception.ResourceNotFoundException;
import com.example.fitnessapp.model.DietPlan;
import com.example.fitnessapp.repository.DietPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DietPlanService {

    @Autowired
    private DietPlanRepository dietPlanRepository;

    public DietPlan createDietPlan(DietPlan plan) {
        return dietPlanRepository.save(plan);
    }

    public List<DietPlan> getAllDietPlans() {
        return dietPlanRepository.findAll();
    }

    public Optional<DietPlan> getDietPlanById(Long id) {
        return dietPlanRepository.findById(id);
    }

    public List<DietPlan> getDietPlansByUserId(Long userId) {
        return dietPlanRepository.findByUserId(userId);
    }

    public DietPlan updateDietPlan(Long id, DietPlan updatedPlan) {
        DietPlan existing = dietPlanRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("DietPlan not found with id: " + id));

        existing.setMealName(updatedPlan.getMealName());
        existing.setDescription(updatedPlan.getDescription());
        existing.setCalories(updatedPlan.getCalories());
        existing.setUserId(updatedPlan.getUserId());

        return dietPlanRepository.save(existing);
    }

    public void deleteDietPlan(Long id) {
        if (!dietPlanRepository.existsById(id)) {
            throw new ResourceNotFoundException("DietPlan not found with id: " + id);
        }
        dietPlanRepository.deleteById(id);
    }
}

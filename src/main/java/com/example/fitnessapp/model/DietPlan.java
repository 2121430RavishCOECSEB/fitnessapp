package com.example.fitnessapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "diet_plans")
public class DietPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Meal name is required")
    private String mealName;

    @NotBlank(message = "Description is required")
    private String description;

    @Positive(message = "Calories must be positive")
    private int calories;

    @Column(name = "user_id")
    private Long userId;

    // Constructors
    public DietPlan() {}

    public DietPlan(String mealName, String description, int calories, Long userId) {
        this.mealName = mealName;
        this.description = description;
        this.calories = calories;
        this.userId = userId;
    }

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

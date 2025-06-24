package com.example.fitnessapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "workout_plans")
public class WorkoutPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    @ElementCollection
    @NotEmpty(message = "Exercises are required")
    private List<String> exercises;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "coach_id")
    private Long coachId;

    public WorkoutPlan() {}

    public WorkoutPlan(String title, String description, List<String> exercises, Long userId, Long coachId) {
        this.title = title;
        this.description = description;
        this.exercises = exercises;
        this.userId = userId;
        this.coachId = coachId;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getExercises() {
        return exercises;
    }

    public void setExercises(List<String> exercises) {
        this.exercises = exercises;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCoachId() {
        return coachId;
    }

    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }
    
}

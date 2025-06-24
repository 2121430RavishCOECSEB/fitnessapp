package com.example.fitnessapp.dto;

public class DashboardMetrics {
    private long totalUsers;
    private long totalCoaches;
    private long totalWorkoutPlans;
    private long totalDietPlans;
    private int totalCaloriesTracked;

    public DashboardMetrics(long totalUsers, long totalCoaches, long totalWorkoutPlans, long totalDietPlans, int totalCaloriesTracked) {
        this.totalUsers = totalUsers;
        this.totalCoaches = totalCoaches;
        this.totalWorkoutPlans = totalWorkoutPlans;
        this.totalDietPlans = totalDietPlans;
        this.totalCaloriesTracked = totalCaloriesTracked;
    }

    // Getters
    public long getTotalUsers() { return totalUsers; }
    public long getTotalCoaches() { return totalCoaches; }
    public long getTotalWorkoutPlans() { return totalWorkoutPlans; }
    public long getTotalDietPlans() { return totalDietPlans; }
    public int getTotalCaloriesTracked() { return totalCaloriesTracked; }
}

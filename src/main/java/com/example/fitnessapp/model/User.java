package com.example.fitnessapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Email must be valid")
    @NotBlank(message = "Email is required")
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    @Column(nullable = false)
    private String password;

    @Min(value = 10, message = "Age must be at least 10")
    private int age;

    @Positive(message = "Weight must be a positive number")
    private double weight;

    @NotBlank(message = "Role is required")
    private String role;  // "USER", "COACH", "ADMIN"

    @NotBlank(message = "Goal is required")
    private String goal;

    @Column(name = "coach_id")
    private Long coachId;

    // Constructors
    public User() {}

    public User(String name, String email, String password, int age, double weight, String role, String goal, Long coachId) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.weight = weight;
        this.role = role;
        this.goal = goal;
        this.coachId = coachId;
    }

    // Getters and Setters
    // (same as before)


    // Getters and Setters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public Long getCoachId() {
        return coachId;
    }

    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }
}

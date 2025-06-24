package com.example.fitnessapp.controller;

import com.example.fitnessapp.model.Coach;
import com.example.fitnessapp.model.User;
import com.example.fitnessapp.service.CoachService;
import com.example.fitnessapp.service.UserService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/coach")
@CrossOrigin(origins = "*")
public class CoachController {

    @Autowired
    private CoachService coachService;
    @Autowired
    private UserService userService;


    // Dashboard (optional)
    @GetMapping("/dashboard")
    public String coachDashboard() {
        return "Welcome to the Coach Dashboard!";
    }

    // Create coach
    @PostMapping
    public Coach createCoach(@Valid @RequestBody Coach coach) {
        return coachService.createCoach(coach);
    }

    // Get all coaches
    @GetMapping
    public List<Coach> getAllCoaches() {
        return coachService.getAllCoaches();
    }

    // Get coach by ID
    @GetMapping("/{id}")
    public Optional<Coach> getCoachById(@PathVariable Long id) {
        return coachService.getCoachById(id);
    }

    // Coach login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Coach loginData) {
        Optional<Coach> coach = coachService.login(loginData.getEmail(), loginData.getPassword());
        if (coach.isPresent()) {
            return ResponseEntity.ok("Coach login successful");
        } else {
            return ResponseEntity.badRequest().body("Invalid email or password");
        }
    }
    @PutMapping("/assign/{userId}")
    public ResponseEntity<?> assignCoach(@PathVariable Long userId, @RequestParam Long coachId) {
        User updatedUser = userService.assignCoachToUser(userId, coachId);
        return ResponseEntity.ok(updatedUser);
    }

}

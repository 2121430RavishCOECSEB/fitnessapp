package com.example.fitnessapp.controller;

import com.example.fitnessapp.dto.LoginRequest;
import com.example.fitnessapp.dto.LoginResponse;
import com.example.fitnessapp.model.User;
import com.example.fitnessapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")  // allow frontend to connect
public class UserController {

    @Autowired
    private UserService userService;

    // Create a new user
    @PostMapping
    public User createUser(@Valid @RequestBody User user) {
        return userService.saveUser(user);
    }

    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get user by ID
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Delete user by ID
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    // Get user by email (for login or lookup)
    @GetMapping("/email/{email}")
    public Optional<User> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    // Get all users by role (e.g., USER, COACH, ADMIN)
    @GetMapping("/role/{role}")
    public List<User> getUsersByRole(@PathVariable String role) {
        return userService.getUsersByRole(role);
    }

    // Get users assigned to a specific coach
    @GetMapping("/coach/{coachId}")
    public List<User> getUsersByCoach(@PathVariable Long coachId) {
        return userService.getUsersByCoach(coachId);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Optional<User> userOpt = userService.login(request.getEmail(), request.getPassword());
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            return ResponseEntity.ok(new LoginResponse("Login successful", user.getRole()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Invalid email or password"));
        }
    }

}

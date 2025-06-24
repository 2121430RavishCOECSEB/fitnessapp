package com.example.fitnessapp.controller;

import com.example.fitnessapp.model.Admin;
import com.example.fitnessapp.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Admin dashboard
    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "Welcome to the Admin Dashboard!";
    }

    // Create admin
    @PostMapping
    public Admin createAdmin(@Valid @RequestBody Admin admin) {
        return adminService.createAdmin(admin);
    }

    // Get all admins
    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    // Get admin by ID
    @GetMapping("/{id}")
    public Optional<Admin> getAdminById(@PathVariable Long id) {
        return adminService.getAdminById(id);
    }

    // Login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Admin loginData) {
        Optional<Admin> admin = adminService.login(loginData.getEmail(), loginData.getPassword());
        if (admin.isPresent()) {
            return ResponseEntity.ok("Admin login successful");
        } else {
            return ResponseEntity.badRequest().body("Invalid email or password");
        }
    }
}

package com.example.fitnessapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserDashboardController {

    @GetMapping("/dashboard")
    public String userDashboard() {
        return "Welcome to the User Dashboard!";
    }
}

package com.example.fitnessapp.controller;

import com.example.fitnessapp.model.Feedback;
import com.example.fitnessapp.service.FeedbackService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = "*")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    // Submit feedback
    @PostMapping
    public ResponseEntity<Feedback> submitFeedback(@Valid @RequestBody Feedback feedback) {
        Feedback saved = feedbackService.submitFeedback(feedback);
        return ResponseEntity.ok(saved);
    }

    // Get all feedbacks
    @GetMapping
    public List<Feedback> getAllFeedback() {
        return feedbackService.getAllFeedback();
    }

    // Get feedback by coach
    @GetMapping("/coach/{coachId}")
    public List<Feedback> getFeedbackByCoach(@PathVariable Long coachId) {
        return feedbackService.getFeedbackByCoach(coachId);
    }

    // Get feedback by user
    @GetMapping("/user/{userId}")
    public List<Feedback> getFeedbackByUser(@PathVariable Long userId) {
        return feedbackService.getFeedbackByUser(userId);
    }

    // Get feedback by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getFeedbackById(@PathVariable Long id) {
        Optional<Feedback> feedback = feedbackService.getFeedbackById(id);
        return feedback.isPresent()
                ? ResponseEntity.ok(feedback.get())
                : ResponseEntity.notFound().build();
    }
}

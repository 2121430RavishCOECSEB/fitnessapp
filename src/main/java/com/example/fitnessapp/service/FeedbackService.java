package com.example.fitnessapp.service;

import com.example.fitnessapp.model.Feedback;
import com.example.fitnessapp.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public Feedback submitFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    public Optional<Feedback> getFeedbackById(Long id) {
        return feedbackRepository.findById(id);
    }

    public List<Feedback> getFeedbackByCoach(Long coachId) {
        return feedbackRepository.findByCoachId(coachId);
    }

    public List<Feedback> getFeedbackByUser(Long userId) {
        return feedbackRepository.findByUserId(userId);
    }
}

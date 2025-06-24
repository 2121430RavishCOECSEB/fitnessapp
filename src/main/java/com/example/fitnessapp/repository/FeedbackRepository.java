package com.example.fitnessapp.repository;

import com.example.fitnessapp.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByCoachId(Long coachId);
    List<Feedback> findByUserId(Long userId);
}

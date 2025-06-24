package com.example.fitnessapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotNull(message = "Coach ID is required")
    private Long coachId;

    @NotBlank(message = "Comment is required")
    private String comment;

    public Feedback() {}

    public Feedback(Long userId, Long coachId, String comment) {
        this.userId = userId;
        this.coachId = coachId;
        this.comment = comment;
    }

    // Getters and Setters
    public Long getId() { return id; }

    public Long getUserId() { return userId; }

    public void setUserId(Long userId) { this.userId = userId; }

    public Long getCoachId() { return coachId; }

    public void setCoachId(Long coachId) { this.coachId = coachId; }

    public String getComment() { return comment; }

    public void setComment(String comment) { this.comment = comment; }
}

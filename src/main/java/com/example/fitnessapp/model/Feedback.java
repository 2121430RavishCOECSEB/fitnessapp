package com.example.fitnessapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long userId;

    @NotNull
    private Long coachId;

    @Min(1)
    @Max(5)
    private int rating;

    @NotBlank
    private String comment;

    // Constructors
    public Feedback() {}

    public Feedback(Long userId, Long coachId, int rating, String comment) {
        this.userId = userId;
        this.coachId = coachId;
        this.rating = rating;
        this.comment = comment;
    }

    // Getters & Setters
    public Long getId() { return id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getCoachId() { return coachId; }
    public void setCoachId(Long coachId) { this.coachId = coachId; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
}
	
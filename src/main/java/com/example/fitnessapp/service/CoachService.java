package com.example.fitnessapp.service;

import com.example.fitnessapp.model.Coach;
import com.example.fitnessapp.repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoachService {

    @Autowired
    private CoachRepository coachRepository;

    public Coach createCoach(Coach coach) {
        return coachRepository.save(coach);
    }

    public List<Coach> getAllCoaches() {
        return coachRepository.findAll();
    }

    public Optional<Coach> getCoachById(Long id) {
        return coachRepository.findById(id);
    }

    public Optional<Coach> login(String email, String password) {
        return coachRepository.findByEmail(email)
                .filter(c -> c.getPassword().equals(password));
    }
}

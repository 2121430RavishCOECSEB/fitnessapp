package com.example.fitnessapp.repository;

import com.example.fitnessapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Custom methods if needed
    Optional<User> findByEmail(String email);

    List<User> findByRole(String role);

    List<User> findByCoachId(Long coachId);
}

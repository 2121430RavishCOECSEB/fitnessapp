package com.example.fitnessapp.service;

import com.example.fitnessapp.exception.BadRequestException;
import com.example.fitnessapp.exception.ResourceNotFoundException;
import com.example.fitnessapp.model.User;
import com.example.fitnessapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create new user with basic checks
    public User saveUser(User user) {
        // Check if email already exists
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new BadRequestException("Email already exists");
        }
        return userRepository.save(user);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Get user by email
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Get users by role (e.g., USER, COACH, ADMIN)
    public List<User> getUsersByRole(String role) {
        return userRepository.findByRole(role);
    }

    // Get users assigned to a coach
    public List<User> getUsersByCoach(Long coachId) {
        return userRepository.findByCoachId(coachId);
    }

    // Update user by ID
    public User updateUser(Long id, User updatedUser) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        // Update fields
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setAge(updatedUser.getAge());
        existingUser.setWeight(updatedUser.getWeight());
        existingUser.setRole(updatedUser.getRole());
        existingUser.setGoal(updatedUser.getGoal());
        existingUser.setCoachId(updatedUser.getCoachId());

        return userRepository.save(existingUser);
    }

    // Delete user by ID
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
    
    public User assignCoachToUser(Long userId, Long coachId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        user.setCoachId(coachId);
        return userRepository.save(user);
    }

 // Login method to verify email and password
    public Optional<User> login(String email, String password) {
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (user.getPassword().equals(password)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

}

package com.example.fitnessapp.service;

import com.example.fitnessapp.model.Admin;
import com.example.fitnessapp.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    public Optional<Admin> login(String email, String password) {
        return adminRepository.findByEmail(email)
                .filter(a -> a.getPassword().equals(password));
    }
}

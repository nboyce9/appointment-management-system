package com.appointment.appointment_system.service;

import com.appointment.appointment_system.model.User;
import com.appointment.appointment_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository repo;
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public void addUser(User user) {
        Optional<User> userOptional = repo.findByEmail(user.getEmailAddress());

        if(user.getEmailAddress().isEmpty() || userOptional.isPresent()){
            throw new IllegalArgumentException("Email is already in use!");
        }
        repo.save(user);
    }
}

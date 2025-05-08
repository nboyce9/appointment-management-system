package com.appointment.appointment_system.service;

import com.appointment.appointment_system.model.Appointment;
import com.appointment.appointment_system.model.AppointmentStatus;
import com.appointment.appointment_system.model.User;
import com.appointment.appointment_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public void addAppointment(int userId, Appointment appointment) {
        Optional<User> userOptional = repo.findById(userId);
        if(userOptional.isEmpty()){
            throw new IllegalArgumentException("Unknown user");
        }
        userOptional.get().addAppointment(appointment);
        User user = userOptional.get();
        repo.save(user);

    }
    public void updateAppointment(int userId, Appointment appointment){
        Optional<User> userOptional = repo.findById(userId);
        if(userOptional.isEmpty()){
            throw new IllegalArgumentException("Unknown user");
        }
        userOptional.get().addAppointment(appointment);
        User user = userOptional.get();
        repo.save(user);
    }

    public void deleteUser(int id) {
        repo.deleteById(id);
    }

    public User getUser(int userId) {
        return repo.findById(userId).get();
    }

    public List<Appointment> getUserAppointments(int userId) {
        Optional<User> user = repo.findById(userId);
        return user.get().getAppointments();
    }

    public List<Appointment> getPastAppointments(int userId){
        List<Appointment> appointmentList = getUserAppointments(userId);
        return appointmentList.stream()
                .filter(appointment -> appointment.getDate().isBefore(LocalDateTime.now()))
                .collect(Collectors.toList());
    }

    public List<Appointment> getUpcomingAppointments(int userId){
        List<Appointment> appointmentList = getUserAppointments(userId);
        return appointmentList.stream()
                .filter(appointment -> appointment.getDate().isAfter(LocalDateTime.now()))
                .collect(Collectors.toList());
    }

    public void cancelAppointment(int userId, Appointment appointment) {
        Optional<User> userOptional = repo.findById(userId);
        if(userOptional.isEmpty()){
            throw new IllegalArgumentException("Unknown user");
        }
//        appointment.setStatus(AppointmentStatus.CANCELLED);
        userOptional.get().cancelAppointment(appointment);
        User user = userOptional.get();
        repo.save(user);
    }
}

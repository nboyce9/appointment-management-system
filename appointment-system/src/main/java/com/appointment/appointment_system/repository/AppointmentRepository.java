package com.appointment.appointment_system.repository;

import com.appointment.appointment_system.model.Appointment;
import com.appointment.appointment_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<User, Integer>{
    @Query("SELECT u FROM User u Where u.emailAddress =?1")
    Optional<Appointment> findByEmail(String email);
}

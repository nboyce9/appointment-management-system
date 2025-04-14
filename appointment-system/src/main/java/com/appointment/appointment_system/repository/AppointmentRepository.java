package com.appointment.appointment_system.repository;

import com.appointment.appointment_system.model.Appointment;
import com.appointment.appointment_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<User, Integer>{
        Optional<Appointment> findByEmail(String email);
}

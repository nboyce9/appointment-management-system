package com.appointment.appointment_system.service;

import com.appointment.appointment_system.model.Appointment;
import com.appointment.appointment_system.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    AppointmentRepository repo;
    public List<Appointment> getAppointments(){
        return repo.findAll();
    }
    public List<Appointment> getAppointmentsByDate(LocalDate date){
        return getAppointments().stream()
                .filter(appointment -> appointment.getDate().toLocalDate().equals(date))
                .toList();
    }
}

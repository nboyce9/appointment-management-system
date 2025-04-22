package com.appointment.appointment_system.service;

import com.appointment.appointment_system.model.Appointment;
import com.appointment.appointment_system.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    AppointmentRepository repo;
    public List<Appointment> getAppointments(){
        return repo.findAll();
    }
    public void addAppointment(){

    }
}

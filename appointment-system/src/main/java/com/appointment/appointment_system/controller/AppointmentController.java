package com.appointment.appointment_system.controller;

import com.appointment.appointment_system.model.Appointment;
import com.appointment.appointment_system.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class AppointmentController {
    @Autowired
    AppointmentService svc;

    @RequestMapping("/appointments")
    public List<Appointment> getAppointments(){
        return svc.getAppointments();
    }

    @PostMapping("/getDayAppointments")
    public List<Appointment> getAppointmentsByDate(@RequestBody LocalDate date){
        return svc.getAppointmentsByDate(date);
    }

    @PostMapping("/getTodaysAppointments")
    public List<Appointment> getTodaysAppointments(@RequestBody LocalDate date){
        return svc.getAppointmentsByDate(LocalDate.now());
    }
}

package com.appointment.appointment_system.controller;

import com.appointment.appointment_system.model.Appointment;
import com.appointment.appointment_system.model.User;
import com.appointment.appointment_system.service.AppointmentService;
import com.appointment.appointment_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService svc;

    @Autowired
    AppointmentService apt;

    @RequestMapping("/")
    public List<User> getUsers(){
        return svc.getAllUsers();
    }

    @PostMapping("/signup")
    public void addUser(@RequestBody User user){
        svc.addUser(user);
    }

    @PostMapping("/{user_id}/book")
    public void addAppointment(@PathVariable int user_id, @RequestBody Appointment appointment){
        svc.addAppointment(user_id, appointment);
    }

    @GetMapping("/{user_id}/{id}/cancel")
    public void cancelAppointment(@PathVariable int user_id, @PathVariable int id){
        svc.cancelAppointment(user_id, id);
    }

    @DeleteMapping("/{user_id}/delete")
    public void deleteUser(@PathVariable int user_id){
        svc.deleteUser(user_id);
    }

    @RequestMapping("{user_id}/user")
    public User getUser(@PathVariable int user_id){
        return svc.getUser(user_id);
    }

    @RequestMapping("{user_id}/appointments")
    public List<Appointment> getUserAppointments(@PathVariable int user_id){
        return svc.getUserAppointments(user_id);
    }

    @RequestMapping("{user_id}/upcoming")
    public List<Appointment> getUpcomingUserAppointments(@PathVariable int user_id){
        return svc.getUpcomingAppointments(user_id);
    }

    @RequestMapping("{user_id}/past")
    public List<Appointment> getPastUserAppointments(@PathVariable int user_id){
        return svc.getPastAppointments(user_id);
    }
}

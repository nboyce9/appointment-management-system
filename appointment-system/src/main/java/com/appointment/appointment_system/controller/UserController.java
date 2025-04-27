package com.appointment.appointment_system.controller;

import com.appointment.appointment_system.model.Appointment;
import com.appointment.appointment_system.model.User;
import com.appointment.appointment_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService svc;

    @RequestMapping("/")
    public List<User> getUsers(){
        return svc.getAllUsers();
    }

    @PostMapping("/signup")
    public void addUser(@RequestBody User user){
        svc.addUser(user);
    }

    @PostMapping("/{user_id}/book")
    public void addAppointment(@PathVariable int userId, @RequestBody Appointment appointment){
        svc.addAppointment(userId, appointment);
    }
}

package com.appointment.appointment_system.controller;

import com.appointment.appointment_system.model.User;
import com.appointment.appointment_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService svc;

    @RequestMapping("/")
    public List<User> getUsers(){
        return svc.getAllUsers();
    }
}

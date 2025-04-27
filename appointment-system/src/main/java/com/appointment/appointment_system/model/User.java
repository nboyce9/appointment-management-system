package com.appointment.appointment_system.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor

@Entity
@Table(name="usersdb")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private String emailAddress;
    private String phoneNumber;
    private UserRole role;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Appointment> appointments = new ArrayList<>();

    public User() {}

    public void addAppointment(Appointment appointment){
        appointments.add(appointment);
        appointment.setUser(this);

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", role=" + role +
                ", appointments=" + appointments +
                '}';
    }
}

package com.appointment.appointment_system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor

@Entity
@Table(name="usersdb")
public class User {
    @Id
    private Long id;
    private String name;
    private String surname;
    private String emailAddress;
    private String phoneNumber;
    private UserRole role;
    private List<Appointment> appointments;

    public User() {}

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

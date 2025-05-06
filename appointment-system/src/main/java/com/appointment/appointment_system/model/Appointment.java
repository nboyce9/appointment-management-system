package com.appointment.appointment_system.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Appointment {
    @Id
    @GeneratedValue
    private Integer id;
    private String location;
    private AppointmentStatus status;
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    public Appointment(){}

    public Appointment(Integer id, String location, LocalDateTime date, AppointmentStatus status, User user) {
        this.id = id;
        this.location = location;
        this.date = date;
        this.status = status;
        this.user = user;
    }

    public Appointment(String location, AppointmentStatus status, LocalDateTime date, User user) {
        this.location = location;
        this.status = status;
        this.date = date;
        this.user = user;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", status=" + status +
                ", date=" + date +
                ", user=" + user +
                '}';
    }
}

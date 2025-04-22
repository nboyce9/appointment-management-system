package com.appointment.appointment_system.model;

import java.time.LocalDate;

public class Appointment {
    private Integer id;
    private String location;
    private AppointmentStatus status;
    private LocalDate date;

    public Appointment(){}

    public Appointment(String location, AppointmentStatus status, LocalDate date) {
        this.location = location;
        this.status = status;
        this.date = date;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", status=" + status +
                ", date=" + date +
                '}';
    }
}

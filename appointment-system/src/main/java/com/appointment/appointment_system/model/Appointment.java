package com.appointment.appointment_system.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
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

    public boolean validTimeSlot(LocalDateTime date){
        if(date.getHour() < 17 && date.getHour() >= 8){
            return true;
        }
        else {
            throw new IllegalArgumentException("Outside business hours.");
        }
    }

    public boolean validDay(LocalDateTime date){
        if(date.getDayOfWeek().getValue() <= 5){
            return true;
        }
        else{
            throw new IllegalArgumentException("Outside working days.");
        }
    }


    public void setDate(LocalDateTime date) {
        if (validTimeSlot(date) && validDay(date)) {
            this.date = date;
        }
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

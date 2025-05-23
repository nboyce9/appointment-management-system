package com.appointment.appointment_system;

import com.appointment.appointment_system.model.Appointment;
import com.appointment.appointment_system.model.AppointmentStatus;
import com.appointment.appointment_system.model.User;
import com.appointment.appointment_system.model.UserRole;
import com.appointment.appointment_system.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class LoadDataBase {
    @Bean
    CommandLineRunner loadData(UserRepository repo) {
        return args -> {
        User lilly =new User("Lilly", "Cartoon", "lillyc@email.com", "0712345678",
                UserRole.CLIENT, new ArrayList<>());
        User stitchy= new User("Stitchy", "Cartoon", "stitchyc@email.com", "0798765432",
                UserRole.CLIENT, new ArrayList<>());
        User papa = new User("Papa", "Cartoon", "papac@email.com", "0716581695",
                UserRole.ADMIN,
                new ArrayList<>());

            Appointment app1 = new Appointment();
            app1.setDate(LocalDateTime.of(2025, 9, 30, 9, 45));
            app1.setLocation("Office");
            app1.setStatus(AppointmentStatus.WAITING);
            lilly.addAppointment(app1);

            Appointment app2 = new Appointment();
            app2.setDate(LocalDateTime.of(2025, 4, 30, 11, 0));
            app2.setLocation("Virtual");
            app2.setStatus(AppointmentStatus.WAITING);
            lilly.addAppointment(app2);
            repo.saveAll(List.of(lilly, stitchy ,papa));
        };
    }
}

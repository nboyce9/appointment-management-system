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
import java.util.ArrayList;
import java.util.List;

@Configuration
public class LoadDataBase {
    @Bean
    CommandLineRunner loadData(UserRepository repo) {
        return args -> {
        User lilo =new User(1L, "Lilo", "Cartoon", "liloc@email.com", "0712345678",
                UserRole.CLIENT, new ArrayList<>());
        User stitch= new User(2L, "Stitch", "Cartoon", "stitchc@email.com", "0798765432",
                UserRole.CLIENT, new ArrayList<>());
        User papa = new User(3L, "Papa", "Cartoon", "papac@email.com", "0716581695",
                UserRole.ADMIN,
                new ArrayList<>());

            Appointment app1 = new Appointment();
            app1.setDate(LocalDate.of(2025, 04, 30));
            app1.setLocation("Office");
            app1.setStatus(AppointmentStatus.WAITING);
            lilo.addAppointment(app1);
            repo.saveAll(List.of(lilo,stitch, papa));
        };
    }
}

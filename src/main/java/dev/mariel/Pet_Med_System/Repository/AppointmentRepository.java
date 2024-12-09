package dev.mariel.Pet_Med_System.Repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.mariel.Pet_Med_System.Model.Appointment;
import dev.mariel.Pet_Med_System.Model.AppointmentStatus;
import dev.mariel.Pet_Med_System.Model.Patient;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByPatient(Patient patient);

    List<Appointment> findByStatus(AppointmentStatus status);

    List<Appointment> findByDateAndTimeBetween(LocalDateTime start, LocalDateTime end);
}

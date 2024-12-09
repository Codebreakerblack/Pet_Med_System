package dev.mariel.Pet_Med_System.Model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private LocalDateTime dateAndTime;

    @Enumerated(EnumType.STRING)
    private AppointmentType type;

    private String reason;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;



    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    public Appointment() {
    }

    public Appointment(LocalDateTime dateAndTime, AppointmentType type, AppointmentStatus status, String reason,
            Patient patient) {
        this.dateAndTime = dateAndTime;
        this.type = type;
        this.reason = reason;
        this.status = status;

    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public AppointmentType getType() {
        return type;
    }

    public void setType(AppointmentType type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
package dev.mariel.Pet_Med_System.DTO;

import java.time.LocalDateTime;

import dev.mariel.Pet_Med_System.Model.AppointmentStatus;
import dev.mariel.Pet_Med_System.Model.AppointmentType;

public class AppointmentResponseDTO {
    private Long patientId;
    private LocalDateTime dateAndTime;
    private AppointmentType type;
    private String reason;
    private AppointmentStatus status;

    public Long getPatientId() {
        return patientId;
    }
    public void setPatientId(Long patientId) {
        this.patientId = patientId;
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

}

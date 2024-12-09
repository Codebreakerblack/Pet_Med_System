package dev.mariel.Pet_Med_System.mapper;

import dev.mariel.Pet_Med_System.DTO.AppointmentRequestDTO;
import dev.mariel.Pet_Med_System.DTO.AppointmentResponseDTO;
import dev.mariel.Pet_Med_System.Model.Appointment;
import dev.mariel.Pet_Med_System.Model.Patient;

public class AppointmentMapper {
        public static AppointmentResponseDTO convertToResponseDTO(Appointment appointment) {
        AppointmentResponseDTO responseDTO = new AppointmentResponseDTO();
        responseDTO.setPatientId(appointment.getPatient().getId());
        responseDTO.setDateAndTime(appointment.getDateAndTime());
        responseDTO.setType(appointment.getType());
        responseDTO.setReason(appointment.getReason());
        responseDTO.setStatus(appointment.getStatus());
        return responseDTO;
    }
    
        public static Appointment convertToEntity(AppointmentRequestDTO requestDTO, Patient patient) {
        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDateAndTime(requestDTO.getDateAndTime());
        appointment.setType(requestDTO.getType());
        appointment.setReason(requestDTO.getReason());
        appointment.setStatus(requestDTO.getStatus());
        return appointment;
    }
}

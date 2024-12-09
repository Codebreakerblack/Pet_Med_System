package dev.mariel.Pet_Med_System.Service;

import dev.mariel.Pet_Med_System.DTO.AppointmentRequestDTO;
import dev.mariel.Pet_Med_System.DTO.AppointmentResponseDTO;
import dev.mariel.Pet_Med_System.Model.Appointment;
import dev.mariel.Pet_Med_System.Model.Patient;
import dev.mariel.Pet_Med_System.Repository.AppointmentRepository;
import dev.mariel.Pet_Med_System.Repository.PatientRepository;
import dev.mariel.Pet_Med_System.mapper.AppointmentMapper;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;

    public AppointmentService(AppointmentRepository appointmentRepository, PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
    }

    public List<AppointmentResponseDTO> getAllAppointments() {
        return appointmentRepository.findAll().stream()
                .map(AppointmentMapper::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public AppointmentResponseDTO createAppointment(Long patientId, AppointmentRequestDTO requestDTO) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Appointment appointment = AppointmentMapper.convertToEntity(requestDTO, patient);

        Appointment savedAppointment = appointmentRepository.save(appointment);

        return AppointmentMapper.convertToResponseDTO(savedAppointment);

    }

    public AppointmentResponseDTO updateAppointment(Long appointmentId, AppointmentRequestDTO requestDTO) {
        Appointment existingAppointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        existingAppointment.setDateAndTime(requestDTO.getDateAndTime());
        existingAppointment.setType(requestDTO.getType());
        existingAppointment.setReason(requestDTO.getReason());
        existingAppointment.setStatus(requestDTO.getStatus());

        Appointment updatedAppointment = appointmentRepository.save(existingAppointment);

        return AppointmentMapper.convertToResponseDTO(updatedAppointment);
    }

    public void deleteAppointment(Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }
}

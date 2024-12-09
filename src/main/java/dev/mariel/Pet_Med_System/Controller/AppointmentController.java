package dev.mariel.Pet_Med_System.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.mariel.Pet_Med_System.DTO.AppointmentRequestDTO;
import dev.mariel.Pet_Med_System.DTO.AppointmentResponseDTO;
import dev.mariel.Pet_Med_System.Service.AppointmentService;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public ResponseEntity<List<AppointmentResponseDTO>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

    @PostMapping("/{patientId}")
    public ResponseEntity<AppointmentResponseDTO> createAppointment(
            @PathVariable Long patientId,
            @RequestBody AppointmentRequestDTO requestDTO) {
        requestDTO.setPatientId(patientId);
        return ResponseEntity.status(201).body(appointmentService.createAppointment(patientId, requestDTO));
    }

    @PutMapping("/{appointmentId}")
    public ResponseEntity<AppointmentResponseDTO> updateAppointment(
            @PathVariable Long appointmentId,
            @RequestBody AppointmentRequestDTO requestDTO) {
        return ResponseEntity.ok(appointmentService.updateAppointment(appointmentId, requestDTO));
    }

    @DeleteMapping("/{appointmentId}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long appointmentId) {
        appointmentService.deleteAppointment(appointmentId);
        return ResponseEntity.noContent().build();
    }

}

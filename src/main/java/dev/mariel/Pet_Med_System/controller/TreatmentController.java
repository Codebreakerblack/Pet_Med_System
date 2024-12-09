package dev.mariel.Pet_Med_System.controller;

import dev.mariel.Pet_Med_System.DTO.TreatmentRequestDTO;
import dev.mariel.Pet_Med_System.DTO.TreatmentResponseDTO;
import dev.mariel.Pet_Med_System.Service.TreatmentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/treatments")
public class TreatmentController {

    private final TreatmentService treatmentService;

    public TreatmentController(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    @GetMapping
    public ResponseEntity<List<TreatmentResponseDTO>> getAllTreatments() {
        List<TreatmentResponseDTO> treatments = treatmentService.getAllTreatments();
        return ResponseEntity.ok(treatments);
    }

    @PostMapping("/{patientId}")
    public ResponseEntity<TreatmentResponseDTO> createTreatment(@PathVariable Long patientId,
            @RequestBody TreatmentRequestDTO treatmentRequestDTO) {
        TreatmentResponseDTO treatment = treatmentService.createTreatment(patientId, treatmentRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(treatment);
    }

    @PutMapping("/{treatmentId}")
    public ResponseEntity<TreatmentResponseDTO> updateTreatment(@PathVariable Long treatmentId,
            @RequestBody TreatmentRequestDTO treatmentRequestDTO) {
        TreatmentResponseDTO updatedTreatment = treatmentService.updateTreatment(treatmentId, treatmentRequestDTO);
        return ResponseEntity.ok(updatedTreatment);
    }

    @DeleteMapping("/{treatmentId}")
    public ResponseEntity<Void> deleteTreatment(@PathVariable Long treatmentId) {
        treatmentService.deleteTreatment(treatmentId);
        return ResponseEntity.noContent().build(); // No content returned after successful deletion
    }
}

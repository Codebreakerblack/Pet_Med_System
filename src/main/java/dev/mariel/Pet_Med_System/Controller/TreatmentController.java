package dev.mariel.Pet_Med_System.Controller;

import dev.mariel.Pet_Med_System.DTO.TreatmentRequestDTO;
import dev.mariel.Pet_Med_System.DTO.TreatmentResponseDTO;
import dev.mariel.Pet_Med_System.Service.TreatmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients/{patientId}/treatments")
public class TreatmentController {

    private final TreatmentService treatmentService;

    public TreatmentController(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    @PostMapping
    public ResponseEntity<Void> addTreatment(
            @PathVariable Long patientId,
            @RequestBody TreatmentRequestDTO treatmentRequestDTO) {
        treatmentService.addTreatment(patientId, treatmentRequestDTO);
        return ResponseEntity.status(201).build(); // Código 201 creado
    }

    @GetMapping
    public ResponseEntity<List<TreatmentResponseDTO>> getTreatmentsForPatient(@PathVariable Long patientId) {
        List<TreatmentResponseDTO> treatments = treatmentService.getTreatmentsForPatient(patientId);
        return ResponseEntity.ok(treatments);
    }
}

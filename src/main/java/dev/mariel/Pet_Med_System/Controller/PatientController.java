package dev.mariel.Pet_Med_System.Controller;

import dev.mariel.Pet_Med_System.DTO.PatientRequestDTO;
import dev.mariel.Pet_Med_System.DTO.PatientResponseDTO;
import dev.mariel.Pet_Med_System.Service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @PostMapping
    public ResponseEntity<PatientResponseDTO> addPatient(@RequestBody PatientRequestDTO patientRequestDTO) {
        return ResponseEntity.status(201).body(patientService.addPatient(patientRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> updatePatient(
            @PathVariable Long id,
            @RequestBody PatientRequestDTO patientRequestDTO) {
        return ResponseEntity.ok(patientService.updatePatient(id, patientRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/identification/{identificationNumber}")
    public ResponseEntity<PatientResponseDTO> getPatientByIdentificationNumber(
            @PathVariable String identificationNumber) {
        return ResponseEntity.ok(patientService.getPatientByIdentificationNumber(identificationNumber));
    }
}

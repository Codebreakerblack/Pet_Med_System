package dev.mariel.Pet_Med_System.Service;

import dev.mariel.Pet_Med_System.DTO.TreatmentRequestDTO;
import dev.mariel.Pet_Med_System.DTO.TreatmentResponseDTO;
import dev.mariel.Pet_Med_System.Model.Patient;
import dev.mariel.Pet_Med_System.Model.Treatment;
import dev.mariel.Pet_Med_System.Repository.PatientRepository;
import dev.mariel.Pet_Med_System.Repository.TreatmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TreatmentService {

    private final TreatmentRepository treatmentRepository;
    private final PatientRepository patientRepository;

    public TreatmentService(TreatmentRepository treatmentRepository, PatientRepository patientRepository) {
        this.treatmentRepository = treatmentRepository;
        this.patientRepository = patientRepository;
    }

    public void addTreatment(Long patientId, TreatmentRequestDTO treatmentRequestDTO) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Treatment treatment = new Treatment();
        treatment.setDescriptionTreatment(treatmentRequestDTO.getDescriptionTreatment());
        treatment.setDate(treatmentRequestDTO.getDate());
        treatment.setPatient(patient);

        treatmentRepository.save(treatment);
    }

    public List<TreatmentResponseDTO> getTreatmentsForPatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        return treatmentRepository.findByPatient(patient).stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    private TreatmentResponseDTO convertToResponseDTO(Treatment treatment) {
        TreatmentResponseDTO responseDTO = new TreatmentResponseDTO();
        responseDTO.setId(treatment.getId());
        responseDTO.setDescriptionTreatment(treatment.getDescriptionTreatment());
        responseDTO.setDate(treatment.getDate());
        return responseDTO;
    }
}

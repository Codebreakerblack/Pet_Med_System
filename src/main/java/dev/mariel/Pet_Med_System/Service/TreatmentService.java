package dev.mariel.Pet_Med_System.Service;

import dev.mariel.Pet_Med_System.DTO.TreatmentRequestDTO;
import dev.mariel.Pet_Med_System.DTO.TreatmentResponseDTO;
import dev.mariel.Pet_Med_System.Model.Patient;
import dev.mariel.Pet_Med_System.Model.Treatment;
import dev.mariel.Pet_Med_System.Repository.PatientRepository;
import dev.mariel.Pet_Med_System.Repository.TreatmentRepository;
import dev.mariel.Pet_Med_System.mapper.TreatmentMapper;

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

    public List<TreatmentResponseDTO> getAllTreatments() {
        return treatmentRepository.findAll().stream()
                .map(TreatmentMapper::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public TreatmentResponseDTO createTreatment(Long patientId, TreatmentRequestDTO requestDTO) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Treatment treatment = TreatmentMapper.convertToEntity(requestDTO);

        treatment.setPatient(patient);

        Treatment savedTreatment = treatmentRepository.save(treatment);

        return TreatmentMapper.convertToResponseDTO(savedTreatment);
    }

    public TreatmentResponseDTO updateTreatment(Long treatmentId, TreatmentRequestDTO requestDTO) {
        Treatment existingTreatment = treatmentRepository.findById(treatmentId)
                .orElseThrow(() -> new RuntimeException("Treatment not found"));

        existingTreatment.setDescriptionTreatment(requestDTO.getDescriptionTreatment());
        existingTreatment.setDate(requestDTO.getDate());

        Treatment updatedTreatment = treatmentRepository.save(existingTreatment);

        return TreatmentMapper.convertToResponseDTO(updatedTreatment);
    }

    public void deleteTreatment(Long treatmentId) {
        treatmentRepository.deleteById(treatmentId);
    }
}

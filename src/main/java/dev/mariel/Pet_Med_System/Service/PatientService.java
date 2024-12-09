package dev.mariel.Pet_Med_System.Service;

import dev.mariel.Pet_Med_System.DTO.PatientRequestDTO;
import dev.mariel.Pet_Med_System.DTO.PatientResponseDTO;
import dev.mariel.Pet_Med_System.Model.Patient;
import dev.mariel.Pet_Med_System.Repository.PatientRepository;
import dev.mariel.Pet_Med_System.mapper.PatientMapper;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getAllPatients() {
        return patientRepository.findAll().stream()
                .map(PatientMapper::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public PatientResponseDTO addPatient(PatientRequestDTO patientRequestDTO) {
        Patient patient = PatientMapper.convertToEntity(patientRequestDTO);
        Patient savedPatient = patientRepository.save(patient);
        return PatientMapper.convertToResponseDTO(savedPatient);
    }

    public PatientResponseDTO updatePatient(Long id, PatientRequestDTO patientRequestDTO) {
        Patient existingPatient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        existingPatient.setName(patientRequestDTO.getName());
        existingPatient.setAge(patientRequestDTO.getAge());
        existingPatient.setBreed(patientRequestDTO.getBreed());
        existingPatient.setGender(patientRequestDTO.getGender());
        existingPatient.setIdentificationNumber(patientRequestDTO.getIdentificationNumber());
        existingPatient.setOwnerName(patientRequestDTO.getOwnerName());
        existingPatient.setOwnerPhone(patientRequestDTO.getOwnerPhone());

        Patient updatedPatient = patientRepository.save(existingPatient);
        return PatientMapper.convertToResponseDTO(updatedPatient);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    public PatientResponseDTO getPatientByIdentificationNumber(String identificationNumber) {
        Patient patient = patientRepository.findByIdentificationNumber(identificationNumber)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        return PatientMapper.convertToResponseDTO(patient);
    }
}
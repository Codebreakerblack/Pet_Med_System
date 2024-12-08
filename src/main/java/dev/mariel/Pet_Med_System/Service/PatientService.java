package dev.mariel.Pet_Med_System.Service;

import dev.mariel.Pet_Med_System.DTO.PatientRequestDTO;
import dev.mariel.Pet_Med_System.DTO.PatientResponseDTO;
import dev.mariel.Pet_Med_System.Model.Patient;
import dev.mariel.Pet_Med_System.Repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    // Obtener todos los pacientes
    public List<PatientResponseDTO> getAllPatients() {
        return patientRepository.findAll().stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public PatientResponseDTO addPatient(PatientRequestDTO patientRequestDTO) {
        Patient patient = convertToEntity(patientRequestDTO);
        Patient savedPatient = patientRepository.save(patient);
        return convertToResponseDTO(savedPatient);
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
        return convertToResponseDTO(updatedPatient);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    public PatientResponseDTO getPatientByIdentificationNumber(String identificationNumber) {
        Patient patient = patientRepository.findByIdentificationNumber(identificationNumber)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        return convertToResponseDTO(patient);
    }

    private PatientResponseDTO convertToResponseDTO(Patient patient) {
        PatientResponseDTO responseDTO = new PatientResponseDTO();
        responseDTO.setId(patient.getId());
        responseDTO.setName(patient.getName());
        responseDTO.setAge(patient.getAge());
        responseDTO.setBreed(patient.getBreed());
        responseDTO.setGender(patient.getGender());
        responseDTO.setIdentificationNumber(patient.getIdentificationNumber());
        responseDTO.setOwnerName(patient.getOwnerName());
        responseDTO.setOwnerPhone(patient.getOwnerPhone());
        return responseDTO;
    }

    private Patient convertToEntity(PatientRequestDTO requestDTO) {
        Patient patient = new Patient();
        patient.setName(requestDTO.getName());
        patient.setAge(requestDTO.getAge());
        patient.setBreed(requestDTO.getBreed());
        patient.setGender(requestDTO.getGender());
        patient.setIdentificationNumber(requestDTO.getIdentificationNumber());
        patient.setOwnerName(requestDTO.getOwnerName());
        patient.setOwnerPhone(requestDTO.getOwnerPhone());
        return patient;
    }
}

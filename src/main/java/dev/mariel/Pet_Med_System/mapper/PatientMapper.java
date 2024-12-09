package dev.mariel.Pet_Med_System.mapper;

import dev.mariel.Pet_Med_System.DTO.PatientRequestDTO;
import dev.mariel.Pet_Med_System.DTO.PatientResponseDTO;
import dev.mariel.Pet_Med_System.Model.Patient;

public class PatientMapper {
    public static PatientResponseDTO convertToResponseDTO(Patient patient) {
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

    public static Patient convertToEntity(PatientRequestDTO requestDTO) {
        if (requestDTO.getName() == null || requestDTO.getName().isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }
        if (requestDTO.getIdentificationNumber() == null || requestDTO.getIdentificationNumber().isEmpty()) {
            throw new IllegalArgumentException("Identification number is required");
        }

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

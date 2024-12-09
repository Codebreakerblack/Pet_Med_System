package dev.mariel.Pet_Med_System.mapper;

import dev.mariel.Pet_Med_System.DTO.TreatmentRequestDTO;
import dev.mariel.Pet_Med_System.DTO.TreatmentResponseDTO;
import dev.mariel.Pet_Med_System.Model.Treatment;
import java.time.format.DateTimeFormatter;

public class TreatmentMapper {
    public static TreatmentResponseDTO convertToResponseDTO(Treatment treatment) {
        TreatmentResponseDTO responseDTO = new TreatmentResponseDTO();
        responseDTO.setId(treatment.getId());
        responseDTO.setDescriptionTreatment(treatment.getDescriptionTreatment());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = treatment.getDate().format(formatter);
        responseDTO.setDate(formattedDate);

        return responseDTO;
    }

    public static Treatment convertToEntity(TreatmentRequestDTO requestDTO) {
        Treatment treatment = new Treatment();
        treatment.setDescriptionTreatment(requestDTO.getDescriptionTreatment());
        treatment.setDate(requestDTO.getDate());
        return treatment;
    }
}

package dev.mariel.Pet_Med_System.DTO;

import java.time.LocalDate;

public class TreatmentRequestDTO {
    private String descriptionTreatment; 
    private LocalDate date;

    public String getDescriptionTreatment() {
        return descriptionTreatment;
    }

    public void setDescriptionTreatment(String descriptionTreatment) {
        this.descriptionTreatment = descriptionTreatment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

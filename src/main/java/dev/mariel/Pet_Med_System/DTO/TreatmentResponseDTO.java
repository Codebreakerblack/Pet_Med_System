package dev.mariel.Pet_Med_System.DTO;

public class TreatmentResponseDTO {
    private Long id;
    private String descriptionTreatment;
    private String date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescriptionTreatment() {
        return descriptionTreatment;
    }

    public void setDescriptionTreatment(String descriptionTreatment) {
        this.descriptionTreatment = descriptionTreatment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

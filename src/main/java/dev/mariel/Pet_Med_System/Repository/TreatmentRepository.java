package dev.mariel.Pet_Med_System.Repository;

import dev.mariel.Pet_Med_System.Model.Patient;
import dev.mariel.Pet_Med_System.Model.Treatment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
    List<Treatment> findByPatient(Patient patient);
}

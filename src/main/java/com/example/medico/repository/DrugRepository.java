package com.example.medico.repository;

import com.example.medico.entity.Drug;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrugRepository
        extends JpaRepository<Drug, Long> {

    List<Drug> findByDiseaseId(Long diseaseId);

    List<Drug> findByDrugNameContainingIgnoreCase(
            String drugName);
}

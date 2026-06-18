package com.example.medico.repository;

import com.example.medico.entity.Disease;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.medico.entity.Category;
import java.util.List;

public interface DiseaseRepository extends JpaRepository<Disease, Long> {

    List<Disease> findByDiseaseNameContainingIgnoreCase(
            String diseaseName);
    //List<Disease> findByCategory_Name(String name);
}
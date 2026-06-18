package com.example.medico.service;

import com.example.medico.entity.Disease;

import java.util.List;

public interface DiseaseService {
    Disease addDisease(Disease disease);

    List<Disease> getAllDisease();

    Disease getDiseaseById(Long id);

    Disease updateDisease(Long id, Disease disease);

    void deleteDisease(Long id);

    List<Disease> searchDisease(String name);

    //List<Disease> getByCategory(String category);
}

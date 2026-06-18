package com.example.medico.service;

import com.example.medico.entity.Symptom;

import java.util.List;

public interface SymptomService {

    Symptom saveSymptom(Symptom symptom);

    List<Symptom> getAllSymptoms();

    Symptom getSymptomById(Long id);

    Symptom updateSymptom(Long id, Symptom symptom);

    void deleteSymptom(Long id);
}

package com.example.medico.service;

import com.example.medico.entity.Symptom;
import com.example.medico.repository.SymptomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SymptomServiceImpl implements SymptomService {

    private final SymptomRepository symptomRepository;

    @Override
    public Symptom saveSymptom(Symptom symptom) {
        return symptomRepository.save(symptom);
    }

    @Override
    public List<Symptom> getAllSymptoms() {
        return symptomRepository.findAll();
    }

    @Override
    public Symptom getSymptomById(Long id) {
        return symptomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Symptom Not Found"));
    }

    @Override
    public Symptom updateSymptom(Long id, Symptom symptom) {

        Symptom existingSymptom = getSymptomById(id);

        existingSymptom.setSymptomName(symptom.getSymptomName());
        existingSymptom.setDescription(symptom.getDescription());
        existingSymptom.setDisease(symptom.getDisease());

        return symptomRepository.save(existingSymptom);
    }

    @Override
    public void deleteSymptom(Long id) {
        symptomRepository.deleteById(id);
    }
}
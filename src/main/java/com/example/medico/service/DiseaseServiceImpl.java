package com.example.medico.service;

import com.example.medico.entity.Disease;
import com.example.medico.repository.DiseaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiseaseServiceImpl implements DiseaseService {

    private final DiseaseRepository repository;

    @Override
    public Disease addDisease(Disease disease) {
        return repository.save(disease);
    }

    @Override
    public List<Disease> getAllDisease() {
        return repository.findAll();
    }

    @Override
    public Disease getDiseaseById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Disease updateDisease(Long id, Disease disease) {
        Disease existing = repository.findById(id).orElse(null);
        if(existing ==null){
            return null;
        }

        existing.setDiseaseName(
                disease.getDiseaseName());

        existing.setSymptom(
                disease.getSymptom());

        existing.setCauses(
                disease.getCauses());

        existing.setDiagnosis(
                disease.getDiagnosis());

        existing.setTreatment(
                disease.getTreatment());

        existing.setPrevention(
                disease.getPrevention());

        existing.setCategory(
                disease.getCategory());

        return repository.save(existing);
    }

    @Override
    public void deleteDisease(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Disease> searchDisease(String name) {
        return repository.findByDiseaseNameContainingIgnoreCase(name);
    }

//    @Override
//    public List<Disease> getByCategory(String category) {
//        return repository.findByCategory_CategoryName(category);
//    }
}

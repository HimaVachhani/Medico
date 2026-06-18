package com.example.medico.service;

import com.example.medico.entity.Drug;
import com.example.medico.repository.DrugRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DrugServiceImpl implements DrugService{

    private final DrugRepository repository;

    @Override
    public Drug save(Drug drug) {
        return repository.save(drug);
    }

    @Override
    public List<Drug> getAll() {
        return repository.findAll();
    }

    @Override
    public Drug getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Drug> getByDisease(Long diseaseId) {
        return repository.findByDiseaseId(diseaseId);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Drug> search(String keyword) {

        return repository
                .findByDrugNameContainingIgnoreCase(
                        keyword);
    }
}

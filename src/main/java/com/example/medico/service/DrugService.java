package com.example.medico.service;

import com.example.medico.entity.Drug;

import java.util.List;

public interface DrugService {
    Drug save(Drug drug);

    List<Drug> getAll();

    Drug getById(Long id);

    List<Drug> getByDisease(Long diseaseId);

    void delete(Long id);

    List<Drug> search(String keyword);
}

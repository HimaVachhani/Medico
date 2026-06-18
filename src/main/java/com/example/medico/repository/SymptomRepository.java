package com.example.medico.repository;

import com.example.medico.entity.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SymptomRepository extends JpaRepository<Symptom,Long> {
}

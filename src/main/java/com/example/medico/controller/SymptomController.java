package com.example.medico.controller;

import com.example.medico.entity.Symptom;
import com.example.medico.service.SymptomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/symptoms")
@RequiredArgsConstructor
public class SymptomController {

    private final SymptomService symptomService;

    @PostMapping
    public Symptom saveSymptom(@RequestBody Symptom symptom) {
        return symptomService.saveSymptom(symptom);
    }

    @GetMapping
    public List<Symptom> getAllSymptoms() {
        return symptomService.getAllSymptoms();
    }

    @GetMapping("/{id}")
    public Symptom getSymptomById(@PathVariable Long id) {
        return symptomService.getSymptomById(id);
    }

    @PutMapping("/{id}")
    public Symptom updateSymptom(
            @PathVariable Long id,
            @RequestBody Symptom symptom) {

        return symptomService.updateSymptom(id, symptom);
    }

    @DeleteMapping("/{id}")
    public String deleteSymptom(@PathVariable Long id) {

        symptomService.deleteSymptom(id);

        return "Symptom Deleted Successfully";
    }
}

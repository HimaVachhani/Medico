package com.example.medico.controller;

import com.example.medico.entity.Drug;
import com.example.medico.repository.DrugRepository;
import com.example.medico.service.DrugService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.List;

@RestController
@RequestMapping("/api/drugs")
@RequiredArgsConstructor
public class DrugController {
    private final DrugService service;

    @PostMapping
    public Drug addDrug(@RequestBody Drug drug) {
        return service.save(drug);
    }

    @GetMapping
    public List<Drug> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Drug getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/disease/{diseaseId}")
    public List<Drug> getByDisease(
            @PathVariable Long diseaseId) {

        return service.getByDisease(diseaseId);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Drug Deleted";
    }

}

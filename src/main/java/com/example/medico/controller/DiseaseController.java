package com.example.medico.controller;

import com.example.medico.entity.Disease;
import com.example.medico.repository.DiseaseRepository;
import com.example.medico.service.DiseaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.List;

@RestController
@RequestMapping("/api/diseases")
@RequiredArgsConstructor

public class DiseaseController {
    private final DiseaseService service;

    @PostMapping
    public Disease addDisease(@RequestBody Disease disease){
        return service.addDisease(disease);
    }

    @GetMapping
    public List<Disease> getAllDisease(){
        return service.getAllDisease();

    }
    @GetMapping("/{id}")
    public Disease getDisease(@PathVariable Long id){
       return service.getDiseaseById(id);
    }

    @PutMapping("/{id}")
    public Disease updateDisease(@PathVariable Long id, @RequestBody Disease disease){
        return service.updateDisease(id, disease);
    }
    @DeleteMapping("/{id}")
    public String deleteDisease(@PathVariable Long id){
        service.deleteDisease(id);
        return "Disease Deleted Successfully";
    }
    @GetMapping("/search")
    public List<Disease> searchDisease(@RequestParam String name){
        return service.searchDisease(name);
    }

//    @GetMapping("/category/{category}")
//    public List<Disease> getByCategory(@RequestParam String category){
//        return service.getByCategory(category);
//    }

}

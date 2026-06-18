package com.example.medico.thymelefcontroller;

import com.example.medico.entity.Symptom;
import com.example.medico.service.DiseaseService;
import com.example.medico.service.SymptomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/symptoms")
@RequiredArgsConstructor
public class SymptomViewController {
    private final SymptomService symptomService;
    private final DiseaseService diseaseService;

    @GetMapping
    public String listSymptoms(Model model) {

        model.addAttribute("symptoms",
                symptomService.getAllSymptoms());

        return "symptom-list";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {

        model.addAttribute("symptom", new Symptom());

        model.addAttribute("diseases",
                diseaseService.getAllDisease());

        return "symptom-form";
    }

    @PostMapping("/save")
    public String saveSymptom(@ModelAttribute Symptom symptom) {

        symptomService.saveSymptom(symptom);

        return "redirect:/symptoms";
    }

    @GetMapping("/edit/{id}")
    public String editSymptom(@PathVariable Long id,
                              Model model) {

        model.addAttribute("symptom",
                symptomService.getSymptomById(id));

        model.addAttribute("diseases",
                diseaseService.getAllDisease());

        return "symptom-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteSymptom(@PathVariable Long id) {

        symptomService.deleteSymptom(id);

        return "redirect:/symptoms";
    }
}

package com.example.medico.thymelefcontroller;

import com.example.medico.entity.Category;
import com.example.medico.entity.Disease;
import com.example.medico.repository.CategoryRepository;
import com.example.medico.service.DiseaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class DiseaseViewController {

    private final DiseaseService diseaseService;
    private final CategoryRepository categoryRepository;

    @GetMapping("/diseases")
    public String getAllDiseases(
            @RequestParam(required = false) String keyword,
            Model model) {

        if (keyword != null && !keyword.isEmpty()) {
            model.addAttribute(
                    "diseases",
                    diseaseService.searchDisease(keyword));
        } else {
            model.addAttribute(
                    "diseases",
                    diseaseService.getAllDisease());
        }

        return "diseases";
    }

    @GetMapping("/diseases/add")
    public String addDiseaseForm(Model model) {

        Disease disease = new Disease();

        // IMPORTANT
        disease.setCategory(new Category());

        model.addAttribute("disease", disease);

        model.addAttribute(
                "categories",
                categoryRepository.findAll());

        return "diseases-form";
    }

    @PostMapping("/diseases/save")
    public String saveDisease(
            @ModelAttribute Disease disease) {

        diseaseService.addDisease(disease);

        return "redirect:/diseases";
    }

    @GetMapping("/diseases/edit/{id}")
    public String editDisease(
            @PathVariable Long id,
            Model model) {

        model.addAttribute(
                "disease",
                diseaseService.getDiseaseById(id));

        model.addAttribute(
                "categories",
                categoryRepository.findAll());

        return "diseases-form";
    }

    @GetMapping("/diseases/delete/{id}")
    public String deleteDisease(
            @PathVariable Long id) {

        diseaseService.deleteDisease(id);

        return "redirect:/diseases";
    }


}

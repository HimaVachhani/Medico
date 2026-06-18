package com.example.medico.thymelefcontroller;
import com.example.medico.entity.Drug;
import com.example.medico.repository.DiseaseRepository;
import com.example.medico.repository.DrugRepository;
import com.example.medico.service.DrugService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/drugs")
public class DrugViewController {

    private final DrugRepository drugRepository;
    private final DiseaseRepository diseaseRepository;
    private final DrugService drugService;

    @GetMapping("/new")
    public String showForm(Model model){

        model.addAttribute(
                "drug",
                new Drug());

        model.addAttribute(
                "diseases",
                diseaseRepository.findAll());

        return "drug-form";
    }

    @PostMapping("/save")
    public String saveDrug(Drug drug){

        drugService.save(drug);

        return "redirect:/drugs";
    }

    @GetMapping("/edit/{id}")
    public String editDrug(
            @PathVariable Long id,
            Model model){

        model.addAttribute(
                "drug",
                drugService.getById(id));

        model.addAttribute(
                "diseases",
                diseaseRepository.findAll());

        return "drug-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteDrug(
            @PathVariable Long id){

        drugService.delete(id);

        return "redirect:/drugs";
    }

    @GetMapping
    public String getAll(
            @RequestParam(required = false)
            String keyword,
            Model model){

        if(keyword != null &&
                !keyword.isEmpty()){

            model.addAttribute(
                    "drugs",
                    drugService.search(keyword));

        } else {

            model.addAttribute(
                    "drugs",
                    drugService.getAll());
        }

        return "drugs";
    }

}
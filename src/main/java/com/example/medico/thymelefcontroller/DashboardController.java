package com.example.medico.thymelefcontroller;

import org.springframework.ui.Model;
import com.example.medico.repository.CategoryRepository;
import com.example.medico.repository.DiseaseRepository;
import com.example.medico.repository.DrugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private DiseaseRepository diseaseRepository;

    @Autowired
    private DrugRepository drugRepository;

    @GetMapping("/")
    public String home() {
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        model.addAttribute(
                "categoryCount",
                categoryRepository.count());

        model.addAttribute(
                "diseaseCount",
                diseaseRepository.count());

        model.addAttribute(
                "drugCount",
                drugRepository.count());

        return "dashboard";
        }
}

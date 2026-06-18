package com.example.medico.thymelefcontroller;

import com.example.medico.entity.Category;
import com.example.medico.repository.CategoryRepository;
import com.example.medico.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CategoryViewController {

    private final CategoryRepository categoryRepository;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories/add")
    public String showAddForm(Model model) {

        model.addAttribute("category", new Category());

        return "category-form";
    }

    @PostMapping("/categories/save")
    public String saveCategory(@ModelAttribute Category category) {

        categoryService.save(category);

        return "redirect:/categories";
    }

    @GetMapping("/categories/edit/{id}")
    public String editCategory(@PathVariable Long id,
                               Model model) {

        model.addAttribute(
                "category",
                categoryService.getById(id));

        return "category-form";
    }

    @GetMapping("/categories/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {

        categoryService.delete(id);

        return "redirect:/categories";
    }

    @GetMapping("/categories")
    public String getAllCategories(
            @RequestParam(required = false) String keyword,
            Model model) {

        List<Category> categories;

        if (keyword != null && !keyword.trim().isEmpty()) {
            categories = categoryRepository
                    .findByNameContainingIgnoreCase(keyword);
        } else {
            categories = categoryRepository.findAll();
        }

        model.addAttribute("categories", categories);

        return "categories";
    }
}

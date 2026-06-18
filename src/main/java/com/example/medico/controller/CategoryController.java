package com.example.medico.controller;

import com.example.medico.entity.Category;
import com.example.medico.repository.CategoryRepository;
import com.example.medico.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @PostMapping
    public Category addCategory(
            @RequestBody Category category) {

        return service.save(category);
    }

    @GetMapping
    public List<Category> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Category getById(
            @PathVariable Long id) {

        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable Long id) {

        service.delete(id);
        return "Category Deleted";
    }

    @GetMapping("/search")
    public String searchCategories(@RequestParam String keyword, Model model) {

        List<Category> categories = service.searchCategories(keyword);

        model.addAttribute("categories", categories);

        return "category/list";
    }
}

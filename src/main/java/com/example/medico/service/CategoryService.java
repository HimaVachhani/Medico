package com.example.medico.service;

import com.example.medico.entity.Category;

import java.util.List;

public interface CategoryService {
    Category save(Category category);

    List<Category> getAll();

    Category getById(Long id);

    List<Category> searchCategories(String keyword);

    void delete(Long id);
}

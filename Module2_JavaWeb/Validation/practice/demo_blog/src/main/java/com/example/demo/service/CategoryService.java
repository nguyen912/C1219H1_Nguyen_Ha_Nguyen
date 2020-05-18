package com.example.demo.service;

import com.example.demo.model.Category;

import java.util.Optional;

public interface CategoryService {
    Iterable<Category> findAll();

    Category findById(Long id);

    Category save(Category category);

    void delete(Category category);

    Category findAllByCategoryName(String name);
}

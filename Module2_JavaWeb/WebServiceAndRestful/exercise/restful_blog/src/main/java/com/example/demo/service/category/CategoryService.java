package com.example.demo.service.category;

import com.example.demo.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById(Integer id);

    Category save(Category category);

    void delete(Category category);
}

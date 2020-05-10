package com.example.demo.service.category;

import com.example.demo.model.Category;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    Iterable<Category> findAllCategory();

    Category findCategoryById(Long id);

    void saveCategory(Category category);

    void removeCategory(Long id);
}

package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.category.CategoryService;
import com.example.demo.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    // Get all categories
    @RequestMapping(value = "/categories/", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> listAllCategories() {
        List<Category> categories = categoryService.findAll();

        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    //Get all posts in a category
    @RequestMapping(value = "/categories/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> getCategory(@PathVariable("id") Integer id) {
        System.out.println("Fetching Category with id" + id);
        Category category = categoryService.findById(id);

        if (category == null) {
            System.out.println("Category with id" + id + "not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}

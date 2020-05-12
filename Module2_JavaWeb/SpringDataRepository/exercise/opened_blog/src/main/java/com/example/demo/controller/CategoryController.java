package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Post;
import com.example.demo.service.category.CategoryService;
import com.example.demo.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {
    @Autowired
    private PostService postService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("categories")
    public ModelAndView listCategories() {
        ModelAndView modelAndView = new ModelAndView("category/list");
        Iterable<Category> categories = categoryService.findAllCategory();
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @GetMapping("/view-category/{id}")
    public ModelAndView viewCategory(@PathVariable("id") Long id){
        Category category = categoryService.findCategoryById(id);
        if(category == null){
            return new ModelAndView("error.404");
        }

        Iterable<Post> posts = postService.findPostsByCategory(category);

        ModelAndView modelAndView = new ModelAndView("category/view");
        modelAndView.addObject("category", category);
        modelAndView.addObject("posts", posts);
        return modelAndView;
    }

    @GetMapping("create-category")
    public ModelAndView showCreateForm() {
        return new ModelAndView("category/create", "category", new Category());
    }

    @PostMapping("create-category")
    public ModelAndView saveCategory(@ModelAttribute Category category) {
        categoryService.saveCategory(category);

        ModelAndView modelAndView = new ModelAndView("category/create");
        modelAndView.addObject("category", category);
        modelAndView.addObject("message", "Category was created successfully!");
        return modelAndView;
    }

    @GetMapping("/edit-category/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Category category = categoryService.findCategoryById(id);

        if(category != null) {
            ModelAndView modelAndView = new ModelAndView("category/edit");
            modelAndView.addObject("category", category);
            return modelAndView;
        }
        else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-category")
    public ModelAndView editCategory(@ModelAttribute Category category) {
        categoryService.saveCategory(category);
        ModelAndView modelAndView = new ModelAndView("/category/edit");
        modelAndView.addObject("category", category);
        modelAndView.addObject("message", "category updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-category/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Category category = categoryService.findCategoryById(id);
        ModelAndView modelAndView;
        if(category != null) {
            modelAndView = new ModelAndView("/category/delete");
            modelAndView.addObject("category", category);

        }
        else {
            modelAndView = new ModelAndView("error.404");
        }
        return modelAndView;
    }

    @PostMapping("/delete-category")
    public String deleteCategory(@ModelAttribute("category") Category category){
        categoryService.removeCategory(category.getId());
        return "redirect:categories";
    }
}

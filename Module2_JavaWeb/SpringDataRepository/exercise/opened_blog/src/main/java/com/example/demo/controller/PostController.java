package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.category.CategoryService;
import com.example.demo.service.post.PostService;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute(name = "categories")
    public Iterable<Category> listCategories() {
        return categoryService.findAllCategory();
    }

    @GetMapping(name = "posts")
    public ModelAndView listPosts(@RequestParam("s") String s, Pageable pageable) {
        Page<Post> posts;
        if (s.isEmpty()) {
            posts = postService.findAllPost(pageable);
        }
        else {
            posts = postService.findPostsByTitleContaining(s, pageable);
        }

        ModelAndView modelAndView = new ModelAndView("post/list");
        modelAndView.addObject(posts);
        return modelAndView;
    }
}

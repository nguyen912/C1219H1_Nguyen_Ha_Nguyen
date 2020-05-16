package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Post;
import com.example.demo.service.category.CategoryService;
import com.example.demo.service.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("posts")
    public ModelAndView listPosts(@RequestParam(value = "s", required = false) String s, Pageable pageable) {
        Page<Post> posts;
        if (s == null) {
            posts = postService.findAllPost(pageable);
        }
        else {
            posts = postService.findPostsByTitleContaining(s, pageable);
        }

        ModelAndView modelAndView = new ModelAndView("post/list");
        modelAndView.addObject("posts", posts);
        return modelAndView;
    }

    @GetMapping("create-post")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("post/create");
        modelAndView.addObject("post", new Post());
        return modelAndView;
    }

    @PostMapping("create-post")
    public ModelAndView savePost(@ModelAttribute Post post) {
        postService.savePost(post);

        ModelAndView modelAndView = new ModelAndView("post/create");
        modelAndView.addObject("post", post);
        modelAndView.addObject("message", "New post was created successfully");
        return modelAndView;
    }

    @GetMapping("edit-post/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Post post = postService.findPostById(id);
        if (post != null) {
            return new ModelAndView("post/edit", "post", post);
        }
        else {
            return new ModelAndView("error.404");
        }
    }

    @PostMapping("edit-post")
    public ModelAndView updatePost(@ModelAttribute Post post) {
        postService.savePost(post);

        ModelAndView modelAndView = new ModelAndView("post/edit");
        modelAndView.addObject("post", post);
        modelAndView.addObject("message", "Post was updated successfully!");
        return modelAndView;
    }

    @GetMapping("delete-post/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Post post = postService.findPostById(id);
        if (post != null) {
            return new ModelAndView("post/delete", "post", post);
        }
        else {
            return new ModelAndView("error.404");
        }
    }

    @PostMapping("delete-post")
    public String deletePost(@ModelAttribute Post post) {
        postService.removePost(post.getId());
        return "redirect:posts"; // tra ve trang posts
    }
}

package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Post;
import com.example.demo.service.CategoryService;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.List;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute(name = "categories")
    private Iterable<Category> categories() {
        return categoryService.findAll();
    }

    @GetMapping("")
    public ModelAndView listPost(@PageableDefault(size = 2) Pageable pageable) {
        Page<Post> posts = postService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("post/list");
        modelAndView.addObject("posts", posts);
        return modelAndView;
    }

    @GetMapping("search-multi-fields")
    public ModelAndView searchMultiFields(@RequestParam(name = "name", required = false, defaultValue = "") String name,
                                          @RequestParam (name = "quickView", required = false, defaultValue = "") String quickView,
                                          @RequestParam (name = "fromDate", required = false, defaultValue = "0") Integer fromDate,
                                          @RequestParam (name = "toDate", required = false, defaultValue = Integer.MAX_VALUE+"") Integer toDate,
                                          @PageableDefault(value=2, size=3) Pageable pageable) {
        Page<Post> posts = postService.findAllByNameBlogContainingAndQuickViewContainingAndPageNumberBetween(name, quickView, fromDate, toDate,pageable);

        ModelAndView modelAndView = new ModelAndView("post/search_multi");
        modelAndView.addObject("posts", posts);
        modelAndView.addObject("sort", "postDate");
        modelAndView.addObject("name", name);
        modelAndView.addObject("quickView", quickView);
        modelAndView.addObject("fromDate", fromDate);
        modelAndView.addObject("toDate", toDate);

        return modelAndView;
    }
}

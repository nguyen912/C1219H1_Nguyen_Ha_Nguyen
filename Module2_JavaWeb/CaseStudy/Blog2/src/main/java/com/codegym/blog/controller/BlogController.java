package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.repository.BlogRepository;
import com.codegym.blog.repository.CategoryRepository;
import com.codegym.blog.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.sql.Date;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PostServiceImpl postService;

    @ModelAttribute("categories")
    public Iterable<Category> categories() {
        return categoryRepository.findAll();
    }

    @GetMapping("")
    public ModelAndView listBlog(@PageableDefault(size = 3) Pageable pageable, @RequestParam(name = "name", required = false, defaultValue = "")  String name) {
        Page<Blog> blogs;
        Sort sort = Sort.by("datePost").descending().and(Sort.by("nameBlog"));
        pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        if(name != null){
            blogs = postService.findAllByNameBlogContaining(name, pageable);
        } else {
            blogs = postService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("list");

        modelAndView.addObject("blogs",blogs);
        modelAndView.addObject("name", name);
        return modelAndView;

    }

    @GetMapping("/search-all")
    public ModelAndView search(@RequestParam(name="value1",required = false, defaultValue = "" ) String value1,
                               @RequestParam(name="value2",required = false, defaultValue = "") String value2,
                               @RequestParam(name = "value3", defaultValue = "0") Integer  value3,
                               @RequestParam(name = "value4", defaultValue = Integer.MAX_VALUE +"") Integer value4,
                               @PageableDefault(value=2, size=3) Pageable pageable){
        Page<Blog> blogs;
        blogs = postService.findAllByNameBlogContainingAndQuickViewContainingAndPageNumberBetween(value1,value2,value3,value4,pageable);

        ModelAndView modelAndView = new ModelAndView("blog/searchall");
        modelAndView.addObject("blogs", blogs);
        modelAndView.addObject("sort", "datePost");
        modelAndView.addObject("value1",value1);
        modelAndView.addObject("value2",value2);
        modelAndView.addObject("value3",value3);
        modelAndView.addObject("value4",value4);


        return modelAndView;
    }

    @GetMapping("/search")
    public  ModelAndView search(@RequestParam(name = "search") String search, @PageableDefault(value=2, size=3) Pageable pageable, @RequestParam("input") String input) throws ParseException {
        Page<Blog> blogs=null;
        Category category;
        switch (search){
            case "name": {
                if(input != null){
                    blogs = postService.findAllByNameBlogContaining(input, pageable);
                } else {
                    blogs = postService.findAll(pageable);
                }

                break;
            }
            case "summary": {
                if(input != null){
                    blogs = postService.findAllByQuickViewContaining(input, pageable);
                } else {
                    blogs = postService.findAll(pageable);
                }
                break;
            }
            case "date": {
                Date date = Date.valueOf(input);
                if(date != null){
                    blogs = postService.findAllByDatePost(date, pageable);
                } else {
                    blogs = postService.findAll(pageable);
                }
                break;
            }
            default:
                blogs = null;
                break;
        }
        ModelAndView modelAndView = new ModelAndView("blog/search");
        modelAndView.addObject("search",search);
        modelAndView.addObject("input",input);
        modelAndView.addObject("blogs", blogs);
        modelAndView.addObject("sort","datePost");
        return modelAndView;
    }


    @GetMapping("/sort")
    public ModelAndView sort(@PageableDefault(value = 2, size = 3)Pageable pageable){
        Page<Blog> blogs = postService.findAllByOrderByDatePostAsc(pageable);
//        int start = (int) pageable.getOffset();
//        int end = Math.min((start + pageable.getPageSize()), blogs.size());
//        int end1 = Math.min(start + pageable.getPageSize(), blogs.size());
//        Page<Blog> pages = new PageImpl<Blog>(blogs.subList(start, end), pageable, blogs.size());
        ModelAndView modelAndView = new ModelAndView("/blog/sort");
        modelAndView.addObject("blogs",blogs);
        return modelAndView;
    }



    @GetMapping("/create-blog")
    public ModelAndView showCreateForm() {
        return new ModelAndView("/blog/create", "blog", new Blog());
    }

    @PostMapping("/create-blog")
    public ModelAndView saveBlog(@ModelAttribute("blog") Blog blog) {
        blog.setDatePost(new Date(System.currentTimeMillis()));
        postService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }

    @GetMapping("/view-blog/{id}")
    public ModelAndView showFullBlog(@PathVariable Long id) {
        Optional<Blog> blog = postService.findById(id);
        if (blog.isPresent()) {
            return new ModelAndView("/blog/view", "blog", blog);

        } else {
            ModelAndView modelAndView = new ModelAndView("/error");
            return modelAndView;
        }
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Blog blog = postService.findById(id).orElse(null);

        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("/blog/edit");
            modelAndView.addObject("blog", blog);
            return modelAndView;
        } else {
            return new ModelAndView("/error");
        }
    }

    @PostMapping("/edit-blog")
    public ModelAndView editBlog(@ModelAttribute("blog") Blog blog) {
        postService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Blog updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Blog> blog = postService.findById(id);
        if (blog != null) {
            return new ModelAndView("/blog/delete", "blog", blog);
        } else {
            return new ModelAndView("/error");
        }
    }

    @PostMapping("/delete-blog")
    public String deleteBlog(@ModelAttribute("blog") Blog blog) {
        blogRepository.deleteById(blog.getId());
        return "redirect:/";
    }
}

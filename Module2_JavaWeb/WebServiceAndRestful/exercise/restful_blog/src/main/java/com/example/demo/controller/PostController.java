package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Post;
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
import java.util.Optional;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private CategoryService categoryService;

    //Get all posts
    @RequestMapping(value = "/posts/", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> listAllPosts() {
        List<Post> posts = postService.findAll();

        if (posts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    //Get a post
    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Post> getPost(@PathVariable("id") Integer id) {
        System.out.println("Fetching Post with id" + id);
        Post post = postService.findById(id);

        if (post == null) {
            System.out.println("Post with id" + id + "not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

}

package com.example.demo.model;

import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer postId;

    private String title;

    private String content;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Post() {
    }

    public Post(String title, String content, Category category) {
        this.title = title;
        this.content = content;
        this.category = category;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

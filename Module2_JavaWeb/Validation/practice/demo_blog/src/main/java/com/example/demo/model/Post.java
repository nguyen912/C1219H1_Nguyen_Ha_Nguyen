package com.example.demo.model;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.sql.Date;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String quickView;

    private String content;

    private Date postDate;

    private int pageNumber;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Post() {
    }

    public Post(String name, String quickView, String content, Date postDate, int pageNumber, Category category) {
        this.name = name;
        this.quickView = quickView;
        this.content = content;
        this.postDate = postDate;
        this.pageNumber = pageNumber;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuickView() {
        return quickView;
    }

    public void setQuickView(String quickView) {
        this.quickView = quickView;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

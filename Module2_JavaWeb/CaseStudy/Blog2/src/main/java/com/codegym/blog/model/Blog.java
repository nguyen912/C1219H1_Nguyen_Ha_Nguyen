package com.codegym.blog.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="blogs")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_blog")
    private String nameBlog;

    @Column(name = "quick_view")
    private String quickView;

    @Column(name = "content")
    private String content;

    @Column(name = "date_post")
    private Date datePost;

    @Column(name = "page_number")
    private int pageNumber;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Blog() {
    }

    public Blog(String nameBlog, String quickView, String content, Date datePost) {
        this.nameBlog = nameBlog;
        this.quickView = quickView;
        this.content = content;
        this.datePost = datePost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameBlog() {
        return nameBlog;
    }

    public void setNameBlog(String nameBlog) {
        this.nameBlog = nameBlog;
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

    public Date getDatePost() {
        return datePost;
    }

    public void setDatePost(Date datePost) {
        this.datePost = datePost;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}

package com.codegym.exam.model;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "discount")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    @Temporal(TemporalType.DATE)
    private Date startTime;

    @Temporal(TemporalType.DATE)
    private Date endTime;

    private Integer discountPercent;

    private String detail;

    public Discount() {
    }

    public Discount(String title, Date startTime, Date endTime, Integer discountPercent, String detail) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        this.discountPercent = discountPercent;
        this.detail = detail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Integer discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}

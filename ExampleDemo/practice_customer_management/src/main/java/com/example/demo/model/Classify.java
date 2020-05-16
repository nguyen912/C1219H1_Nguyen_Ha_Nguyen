package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "classify")
public class Classify {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String classifyName;

    @OneToMany(targetEntity = Customer.class)
    List<Customer> customers;

    public Classify() {
    }

    public Classify(String classifyName, List<Customer> customers) {
        this.classifyName = classifyName;
        this.customers = customers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}

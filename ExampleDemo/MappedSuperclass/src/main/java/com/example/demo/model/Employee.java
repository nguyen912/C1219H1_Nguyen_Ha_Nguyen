package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Employee extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Employee() {
    }

    public Employee(Integer id) {
        this.id = id;
    }

    public Employee(String name, Integer age, Integer id) {
        super(name, age);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

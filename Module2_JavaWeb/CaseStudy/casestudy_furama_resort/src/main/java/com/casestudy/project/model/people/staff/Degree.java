package com.casestudy.project.model.people.staff;

import javax.persistence.*;
import java.util.List;

@Entity
public class Degree {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String degreeName;

    @OneToMany(targetEntity = Employee.class)
    private List<Employee> employees;

    public Degree() {
    }

    public Degree(String degreeName, List<Employee> employees) {
        this.degreeName = degreeName;
        this.employees = employees;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}

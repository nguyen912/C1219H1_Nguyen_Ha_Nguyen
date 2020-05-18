package com.codegym.exam.model;

import com.codegym.exam.model.Employee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roleId;

    private String roleName;

    @OneToMany(targetEntity = Employee.class)
    private List<Employee> employees;

    public Role() {
    }

    public Role(String roleName, List<Employee> employees) {
        this.roleName = roleName;
        this.employees = employees;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}

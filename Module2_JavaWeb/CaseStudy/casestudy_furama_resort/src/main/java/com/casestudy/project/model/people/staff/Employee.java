package com.casestudy.project.model.people.staff;

import com.casestudy.project.StringPrefixedSequenceIdGenerator;
import com.casestudy.project.model.contract.Contract;
import com.casestudy.project.model.people.PersonInfo;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Entity
public class Employee extends PersonInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    @GenericGenerator(
            name = "employee_seq",
            strategy = "com.casestudy.project.StringPrefixedSequenceIdGenerator",
            parameters = {
//                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "NV-"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")
            }
    )
    private String id;

    @Min(1)
    private Long salary;

    @ManyToOne
    @JoinColumn(name = "fk_degree")
    private Degree degree;

    @ManyToOne
    @JoinColumn(name = "fk_role")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "fk_department")
    private Department department;

    @OneToMany(targetEntity = Contract.class)
    private List<Contract> contracts;

    public Employee() {
    }

    public Employee(@Min(1) Long salary, Degree degree, Role role, Department department, List<Contract> contracts) {
        this.salary = salary;
        this.degree = degree;
        this.role = role;
        this.department = department;
        this.contracts = contracts;
    }

    public Employee(@NotBlank String name,
                    Date birthday,
                    @Pattern(regexp = "(^\\d{9}$)|(^\\d{12}$)") String idCard,
                    @Pattern(regexp = "^((09)|(\\(84\\)\\+9))(0|1)\\d{7}$") String phoneNumber,
                    @Email String email,
                    @NotBlank String address,
                    @Min(1) Long salary,
                    Degree degree,
                    Role role,
                    Department department,
                    List<Contract> contracts) {
        super(name, birthday, idCard, phoneNumber, email, address);
        this.salary = salary;
        this.degree = degree;
        this.role = role;
        this.department = department;
        this.contracts = contracts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}

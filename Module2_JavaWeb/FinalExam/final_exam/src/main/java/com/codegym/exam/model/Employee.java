package com.codegym.exam.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;

    @NotEmpty
    @Size(min = 2, max = 255)
    private String name;

//    @Past
//    @Temporal(TemporalType.DATE)
//    private String birthday;

    @Pattern(regexp = "male|female")
    private String gender;

    @Pattern(regexp = "^0[0-9]{9}$")
    private String phoneNumber;

    @Pattern(regexp = "^[0-9]{10}$")
    private String idCard;

    @Email
    private String email;

    @Size(min = 5, max = 255)
    private String address;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public Employee() {
    }

    public Employee(@NotEmpty @Size(min = 2, max = 255) String name, @Past String birthday, @Pattern(regexp = "male|female") String gender, @Pattern(regexp = "^0[0-9]{9}$") String phoneNumber, @Pattern(regexp = "^[0-9]{10}$") String idCard, @Email String email, @Size(min = 5, max = 255) String address, Role role) {
        this.name = name;
//        this.birthday = birthday;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.idCard = idCard;
        this.email = email;
        this.address = address;
        this.role = role;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getBirthday() {
//        return birthday;
//    }
//
//    public void setBirthday(String birthday) {
//        this.birthday = birthday;
//    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

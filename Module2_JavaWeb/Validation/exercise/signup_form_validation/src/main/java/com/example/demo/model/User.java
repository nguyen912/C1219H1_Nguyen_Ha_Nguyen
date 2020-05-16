package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "first_name")
    @NotNull(message = "First name không được để trống!")
    @Size(min = 5, max = 45)
    private String firstName;
    
    @Column(name = "last_name")
    @NotNull(message = "Last name không được để trống!")
    @Size(min = 5, max = 45)
    private String lastName;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @Min(value = 18)
    private Integer age;

    @Email(message = "sai email")
    private String email;

    public User() {
    }

    public User(@NotNull(message = "First name không được để trống!") @Size(min = 5, max = 45) String firstName, @NotNull(message = "Last name không được để trống!") @Size(min = 5, max = 45) String lastName, @Pattern(regexp = "^0\\d{9}$") Long phoneNumber, @Min(18) Integer age, @Email String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

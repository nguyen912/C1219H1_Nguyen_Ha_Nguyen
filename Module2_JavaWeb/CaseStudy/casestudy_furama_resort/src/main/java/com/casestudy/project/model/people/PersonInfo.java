package com.casestudy.project.model.people;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PersistenceUnit;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.*;
import java.util.Date;

@MappedSuperclass
public class PersonInfo {
    @NotBlank(message = "Not Empty!")
    private String name;

    @NotNull(message = "Not Empty!")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date birthday;

    @Column(name = "id_card", unique = true)
    @Pattern(regexp = "(^\\d{9}$)|(^\\d{12}$)")
    private String idCard;

    @Pattern(regexp = "^((09)|(\\(84\\)\\+9))(0|1)\\d{7}$")
    private String phoneNumber;

    @Email (message = "Email must be abc@abc.com")
    private String email;

    @NotBlank
    private String address;

    public PersonInfo() {
    }

    public PersonInfo(@NotBlank String name,
                      @DateTimeFormat(pattern = "DD/MM/YYYY") Date birthday,
                      @Pattern(regexp = "(^\\d{9}$)|(^\\d{12}$)") String idCard,
                      @Pattern(regexp = "^((09)|(\\(84\\)\\+9))(0|1)\\d{7}$") String phoneNumber,
                      @Email String email,
                      @NotBlank String address) {
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
}

package com.casestudy.project.model.people.customer;

import com.casestudy.project.StringPrefixedSequenceIdGenerator;
import com.casestudy.project.model.contract.Contract;
import com.casestudy.project.model.people.PersonInfo;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Entity
public class Customer extends PersonInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @GenericGenerator(
            name = "customer_seq",
            strategy = "com.casestudy.project.StringPrefixedSequenceIdGenerator",
            parameters = {
//                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "KH-"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")
            }
    )
    private String id;

    @ManyToOne
    @JoinColumn(name = "fk_customer_type")
    private CustomerType customerType;

    @OneToMany(targetEntity = Contract.class)
    private List<Contract> contracts;

    public Customer() {
    }

    public Customer(CustomerType customerType, List<Contract> contracts) {
        this.customerType = customerType;
        this.contracts = contracts;
    }

    public Customer(@NotBlank String name,
                    Date birthday,
                    @Pattern(regexp = "(^\\d{9}$)|(^\\d{12}$)") String idCard,
                    @Pattern(regexp = "^((09)|(\\(84\\)\\+9))(0|1)\\d{7}$") String phoneNumber,
                    @Email String email,
                    @NotBlank String address,
                    CustomerType customerType,
                    List<Contract> contracts) {
        super(name, birthday, idCard, phoneNumber, email, address);
        this.customerType = customerType;
        this.contracts = contracts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}

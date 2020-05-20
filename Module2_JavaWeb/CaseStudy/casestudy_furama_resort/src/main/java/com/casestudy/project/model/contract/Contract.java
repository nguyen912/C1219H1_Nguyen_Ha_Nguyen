package com.casestudy.project.model.contract;

import com.casestudy.project.model.people.customer.Customer;
import com.casestudy.project.model.people.staff.Employee;
import com.casestudy.project.model.service.Service;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Date;
import java.util.List;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_employee")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "fk_customer")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "fk_service")
    private Service service;

    @OneToMany(targetEntity = DetailContract.class)
    private List<DetailContract> detailContracts;

    @DateTimeFormat(pattern = "DD/MM/YYYY")
    private Date contractStartDate;

    @DateTimeFormat(pattern = "DD/MM/YYYY")
    private Date contractEndDate;

    @Min(1)
    private Long deposit;

    @Min(1)
    private Long total;

    public Contract() {
    }

    public Contract(Employee employee, Customer customer, Service service, List<DetailContract> detailContracts, Date contractStartDate, Date contractEndDate, @Min(1) Long deposit, @Min(1) Long total) {
        this.employee = employee;
        this.customer = customer;
        this.service = service;
        this.detailContracts = detailContracts;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.deposit = deposit;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<DetailContract> getDetailContracts() {
        return detailContracts;
    }

    public void setDetailContracts(List<DetailContract> detailContracts) {
        this.detailContracts = detailContracts;
    }

    public Date getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(Date contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public Date getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(Date contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public Long getDeposit() {
        return deposit;
    }

    public void setDeposit(Long deposit) {
        this.deposit = deposit;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}

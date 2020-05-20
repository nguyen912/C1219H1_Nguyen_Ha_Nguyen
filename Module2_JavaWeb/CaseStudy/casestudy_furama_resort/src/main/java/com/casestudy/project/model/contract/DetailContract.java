package com.casestudy.project.model.contract;

import com.casestudy.project.model.service.OtherService;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
public class DetailContract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_contract")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "fk_other_service")
    private OtherService otherService;

    @Min(1)
    private Integer amount;

    public DetailContract() {
    }

    public DetailContract(Contract contract, OtherService otherService, @Min(1) Integer amount) {
        this.contract = contract;
        this.otherService = otherService;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public OtherService getOtherService() {
        return otherService;
    }

    public void setOtherService(OtherService otherService) {
        this.otherService = otherService;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}

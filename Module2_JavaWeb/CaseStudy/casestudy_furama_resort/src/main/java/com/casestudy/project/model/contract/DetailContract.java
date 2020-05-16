package com.casestudy.project.model.contract;

import com.casestudy.project.model.service.OtherService;

import javax.persistence.*;

@Entity
@Table(name = "detail_contract")
public class DetailContract {
    //id_hop_dong_chi_tiet, id_hop_dong, id_dich_vu_di_kem, so_luong
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "other_service_id")
    private OtherService otherService;

    private Integer amount;

    public DetailContract() {
    }

    public DetailContract(Contract contract, OtherService otherService, Integer amount) {
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

package com.casestudy.project.model.service;

import com.casestudy.project.model.contract.DetailContract;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "other_service")
public class OtherService {
    //id_dich_vu_di_kem, ten_dich_vu_di_kem, gia, don_vi, trang_thai_kha_dung
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String otherServiceName;

    private Long otherServiceCost;

    private String unit;

    private String availabilityStatus;

    @OneToMany(targetEntity = DetailContract.class)
    private List<DetailContract> detailContracts;

    public OtherService() {
    }

    public OtherService(String otherServiceName, Long otherServiceCost, String unit, String availabilityStatus, List<DetailContract> detailContracts) {
        this.otherServiceName = otherServiceName;
        this.otherServiceCost = otherServiceCost;
        this.unit = unit;
        this.availabilityStatus = availabilityStatus;
        this.detailContracts = detailContracts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOtherServiceName() {
        return otherServiceName;
    }

    public void setOtherServiceName(String otherServiceName) {
        this.otherServiceName = otherServiceName;
    }

    public Long getOtherServiceCost() {
        return otherServiceCost;
    }

    public void setOtherServiceCost(Long otherServiceCost) {
        this.otherServiceCost = otherServiceCost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public List<DetailContract> getDetailContracts() {
        return detailContracts;
    }

    public void setDetailContracts(List<DetailContract> detailContracts) {
        this.detailContracts = detailContracts;
    }
}

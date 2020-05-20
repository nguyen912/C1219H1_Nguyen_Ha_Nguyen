package com.casestudy.project.model.service;

import com.casestudy.project.StringPrefixedSequenceIdGenerator;
import com.casestudy.project.model.contract.Contract;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service_seq")
    @GenericGenerator(
            name = "service_seq",
            strategy = "com.casestudy.project.StringPrefixedSequenceIdGenerator",
            parameters = {
//                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "DV-"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d")
            }
    )
    private String id;

    @NotBlank
    private String serviceName;

    @Min(1)
    private Double roomArea;

    @Min(1)
    private Integer floors;

    @Min(1)
    private Integer maxPeople;

    @Min(1)
    private Long rentCost;

    private String status;

    @ManyToOne
    @JoinColumn(name = "fk_service_type")
    private ServiceType serviceType;

    @ManyToOne
    @JoinColumn(name = "fk_rent_type")
    private RentType rentType;

    @OneToMany(targetEntity = Contract.class)
    private List<Contract> contracts;

    public Service() {
    }

    public Service(@NotBlank String serviceName,
                   @Min(1) Double roomArea,
                   @Min(1) Integer floors,
                   @Min(1) Integer maxPeople,
                   @Min(1) Long rentCost,
                   String status,
                   ServiceType serviceType,
                   RentType rentType,
                   List<Contract> contracts) {
        this.serviceName = serviceName;
        this.roomArea = roomArea;
        this.floors = floors;
        this.maxPeople = maxPeople;
        this.rentCost = rentCost;
        this.status = status;
        this.serviceType = serviceType;
        this.rentType = rentType;
        this.contracts = contracts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Double getRoomArea() {
        return roomArea;
    }

    public void setRoomArea(Double roomArea) {
        this.roomArea = roomArea;
    }

    public Integer getFloors() {
        return floors;
    }

    public void setFloors(Integer floors) {
        this.floors = floors;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public Long getRentCost() {
        return rentCost;
    }

    public void setRentCost(Long rentCost) {
        this.rentCost = rentCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}

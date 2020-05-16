package com.casestudy.project.model.service;

import com.casestudy.project.model.contract.Contract;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String serviceName;

    private Double roomArea;

    private Integer floors;

    private Integer maxPeople;

    private Long rentCost;

    private String status;

    @ManyToOne
    @JoinColumn(name = "service_type_id")
    private Service service;

    @ManyToOne
    @JoinColumn(name = "rent_type_id")
    private RentType rentType;

    @OneToMany(targetEntity = Contract.class)
    private List<Contract> contracts;

    public Service() {
    }

    public Service(String serviceName, Double roomArea, Integer floors, Integer maxPeople, Long rentCost, String status, Service service, RentType rentType, List<Contract> contracts) {
        this.serviceName = serviceName;
        this.roomArea = roomArea;
        this.floors = floors;
        this.maxPeople = maxPeople;
        this.rentCost = rentCost;
        this.status = status;
        this.service = service;
        this.rentType = rentType;
        this.contracts = contracts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
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

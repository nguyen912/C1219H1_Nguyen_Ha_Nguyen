package com.casestudy.project.model.service;

import javax.persistence.*;
import java.util.List;

@Entity
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String serviceTypeName;

    @OneToMany(targetEntity = Service.class)
    private List<Service> services;

    public ServiceType() {
    }

    public ServiceType(String serviceTypeName, List<Service> services) {
        this.serviceTypeName = serviceTypeName;
        this.services = services;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}

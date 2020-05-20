package com.casestudy.project.service.service_type;

import com.casestudy.project.model.service.ServiceType;

import java.util.List;

public interface ServiceTypeService {
    List<ServiceType> findAll();

    ServiceType findById(Integer id);

    ServiceType save(ServiceType serviceType);

    void delete(ServiceType serviceType);
}

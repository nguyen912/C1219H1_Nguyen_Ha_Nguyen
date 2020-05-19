package com.casestudy.project.service.service;

import com.casestudy.project.model.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceService {
    Page<Service> findAll(Pageable pageable);

    Service findById(Integer id);
}

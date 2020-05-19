package com.casestudy.project.repository;

import com.casestudy.project.model.service.Service;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ServiceRepository extends PagingAndSortingRepository<Service, Integer> {
}

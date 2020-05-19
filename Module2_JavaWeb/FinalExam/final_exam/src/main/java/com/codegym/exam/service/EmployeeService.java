package com.codegym.exam.service;

import com.codegym.exam.model.Discount;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Iterable<Discount> findAll(Pageable pageable);

    Discount findById(Long id);

    void save(Discount discount);

    void delete(Discount discount);
}

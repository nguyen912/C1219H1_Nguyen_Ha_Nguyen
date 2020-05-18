package com.codegym.exam.service;

import com.codegym.exam.model.Employee;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Iterable<Employee> findAll(Pageable pageable);

    Employee findById(Long id);

    void save(Employee employee);

    void delete(Employee employee);
}

package com.codegym.exam.service;

import com.codegym.exam.model.Discount;
import com.codegym.exam.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Iterable<Discount> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Discount findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Discount discount) {
        employeeRepository.save(discount);
    }

    @Override
    public void delete(Discount discount) {
        employeeRepository.delete(discount);
    }
}

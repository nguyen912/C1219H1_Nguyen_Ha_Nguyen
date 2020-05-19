package com.codegym.exam.repository;

import com.codegym.exam.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Discount, Long> {

}

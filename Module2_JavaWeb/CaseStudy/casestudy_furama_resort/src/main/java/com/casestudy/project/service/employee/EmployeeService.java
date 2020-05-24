package com.casestudy.project.service.employee;

import com.casestudy.project.model.people.staff.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);

    Employee save(Employee employee);
}

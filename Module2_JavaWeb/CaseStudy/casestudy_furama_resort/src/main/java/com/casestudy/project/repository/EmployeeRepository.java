package com.casestudy.project.repository;

import com.casestudy.project.model.people.staff.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, String> {
}

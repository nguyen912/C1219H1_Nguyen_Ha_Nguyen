package com.casestudy.project.repository;

import com.casestudy.project.model.people.staff.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}

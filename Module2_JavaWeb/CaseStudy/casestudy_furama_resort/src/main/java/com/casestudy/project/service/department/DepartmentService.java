package com.casestudy.project.service.department;

import com.casestudy.project.model.people.staff.Department;

public interface DepartmentService {
    Iterable<Department> findAll();
}

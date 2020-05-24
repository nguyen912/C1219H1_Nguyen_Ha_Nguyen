package com.casestudy.project.repository;

import com.casestudy.project.model.people.staff.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}

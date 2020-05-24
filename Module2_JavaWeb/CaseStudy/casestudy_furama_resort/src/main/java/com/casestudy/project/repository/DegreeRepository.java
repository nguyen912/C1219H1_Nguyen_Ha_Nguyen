package com.casestudy.project.repository;

import com.casestudy.project.model.people.staff.Degree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DegreeRepository extends JpaRepository<Degree, Integer> {
}

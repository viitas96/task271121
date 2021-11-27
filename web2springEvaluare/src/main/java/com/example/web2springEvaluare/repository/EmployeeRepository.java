package com.example.web2springEvaluare.repository;

import com.example.web2springEvaluare.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

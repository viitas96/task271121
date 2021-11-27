package com.example.web2springEvaluare.service;

import com.example.web2springEvaluare.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);
    List<Employee> getAll();
    Employee get(long id);
    Employee updateEmployee(Employee employee, long id);
    void deleteEmployee(long id);
}

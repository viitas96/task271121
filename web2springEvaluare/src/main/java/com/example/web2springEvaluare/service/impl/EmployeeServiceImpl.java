package com.example.web2springEvaluare.service.impl;

import com.example.web2springEvaluare.model.Employee;
import com.example.web2springEvaluare.repository.EmployeeRepository;
import com.example.web2springEvaluare.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee save(Employee employee) { return employeeRepository.save(employee); }

    @Override
    public List<Employee> getAll() { return employeeRepository.findAll(); }

    @Override
    public Employee get(long id) {
        return employeeRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(null);
        existingEmployee.setIdnp(employee.getIdnp());
        existingEmployee.setName(employee.getName());
        existingEmployee.setSurname(employee.getSurname());
        existingEmployee.setSalary(employee.getSalary());
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.findById(id).orElseThrow(null);
        employeeRepository.deleteById(id);
    }
}

package com.example.web2springEvaluare.controller;

import com.example.web2springEvaluare.model.Employee;
import com.example.web2springEvaluare.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.save(employee), HttpStatus.OK);
    }

    @GetMapping
    public List<Employee> get(){ return employeeService.getAll(); }

    @GetMapping("{id}")
    public ResponseEntity<Employee> get(@PathVariable("id") long id){
        return new ResponseEntity<Employee>(employeeService.get(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> update(@RequestBody Employee employee,
                                           @PathVariable("id") long id){
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee has been deleted", HttpStatus.OK);
    }
}

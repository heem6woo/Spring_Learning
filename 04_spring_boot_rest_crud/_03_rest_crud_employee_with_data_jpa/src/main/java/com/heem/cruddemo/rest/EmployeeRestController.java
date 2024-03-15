package com.heem.cruddemo.rest;

import com.heem.cruddemo.entity.Employee;
import com.heem.cruddemo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable int id) {

        Employee found = employeeService.findById(id);
        if (found == null) {
            throw new RuntimeException("Employee with " + id + " is not found.");
        }
        return found;
    }

    @PostMapping("/employees")
    public Employee getEmployee(@RequestBody Employee theEmployee) {


        theEmployee.setId(0);

        return employeeService.save(theEmployee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {

        return employeeService.save(theEmployee);
    }

    @DeleteMapping("/employees/{id}")
    public Employee deleteEmployee(@PathVariable int id) {

        Employee temp = employeeService.findById(id);

        if (temp == null) {
            throw new RuntimeException("Employee with " + id + " is not found.");
        }

        employeeService.deleteById(id);

        return temp;
    }



}

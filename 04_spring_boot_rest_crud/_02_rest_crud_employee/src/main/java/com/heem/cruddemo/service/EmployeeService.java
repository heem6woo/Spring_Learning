package com.heem.cruddemo.service;

import com.heem.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    // add or update employee
    Employee save(Employee employee);

    void deleteById(int id);

    void deleteAll();


}

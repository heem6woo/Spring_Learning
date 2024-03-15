package com.heem.cruddemo.dao;

import com.heem.cruddemo.entity.Employee;

import java.util.List;


public interface EmployeeDAO {

    Employee findById(int id);

    List<Employee> findAll();


    // add or update employee
    Employee save(Employee employee);

    void deleteById(int id);

    void deleteAll();
}

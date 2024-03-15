package com.heem.cruddemo.dao;

import com.heem.cruddemo.entity.Employee;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoJpaImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll(){

        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);

        return theQuery.getResultList();

    }

    @Override
    public Employee findById(int id) {


        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {

        Employee dbEmployee = entityManager.merge(employee);

        return dbEmployee;

    }

    @Override
    public void deleteById(int id) {
        entityManager.remove(findById(id));
    }

    @Override
    public void deleteAll() {
        entityManager.clear();
    }
}

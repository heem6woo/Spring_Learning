package com.heem.crud.dao;

import com.heem.crud.entity.Student;
import jakarta.persistence.EntityManager;

import java.util.List;

public interface StudentDao {


    void save(Student student);

    Student findById(int id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student student);

    void delete(int id);

    int deleteAll();

}

package com.heem.crud.dao;

import com.heem.crud.entity.Student;
import jakarta.persistence.EntityManager;

public interface StudentDao {


    void save(Student student);

    Student findById(int id);
}

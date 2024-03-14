package com.heem.crud.dao;

import com.heem.crud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//
@Repository
public class StudentDaoImpl implements StudentDao{

    //define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor
    @Autowired
    public StudentDaoImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    //implement save method
    //
    // Transactional for JPA
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    @Transactional
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }
}

package com.heem.crud.dao;

import com.heem.crud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public Student findById(int id) throws IllegalArgumentException {

        return entityManager.find(Student.class, id);

    }

    @Override
    public List<Student> findAll() {

        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class );

        return theQuery.getResultList();

    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        // set query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);

        // set parameter theData
        theQuery.setParameter("theData", theLastName);

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }
    @Override
    @Transactional
    public void delete(int id) {
        Student student = findById(id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        /*
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        List<Student> allStudents = theQuery.getResultList();
        for(Student student: allStudents) {
            entityManager.remove(student);
        }

         */
        int deletedRows = entityManager.createQuery("DELETE FROM Student").executeUpdate();

        return deletedRows;

    }

}

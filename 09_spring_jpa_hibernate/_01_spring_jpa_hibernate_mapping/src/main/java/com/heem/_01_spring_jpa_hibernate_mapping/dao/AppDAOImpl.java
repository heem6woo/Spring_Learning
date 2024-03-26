package com.heem._01_spring_jpa_hibernate_mapping.dao;

import com.heem._01_spring_jpa_hibernate_mapping.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class AppDAOImpl implements AppDAO {

    // define field for entity manager

    // inject entity manger using constructor injection
    private EntityManager entityManager;

    public AppDAOImpl(EntityManager theEntityManger) {
        entityManager = theEntityManger;

    }
    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        // retrieve the instructor
        Instructor tempInstructor = findInstructorById(theId);

        // delete the instructor
        entityManager.remove(tempInstructor);

    }
}

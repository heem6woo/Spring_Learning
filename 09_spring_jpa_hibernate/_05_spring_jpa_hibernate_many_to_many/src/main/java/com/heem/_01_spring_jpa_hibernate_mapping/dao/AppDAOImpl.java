package com.heem._01_spring_jpa_hibernate_mapping.dao;

import com.heem._01_spring_jpa_hibernate_mapping.entity.Course;
import com.heem._01_spring_jpa_hibernate_mapping.entity.Instructor;
import com.heem._01_spring_jpa_hibernate_mapping.entity.InstructorDetail;
import com.heem._01_spring_jpa_hibernate_mapping.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {

    // define field for entity manager

    // inject entity manger using constructor injection
    private EntityManager entityManager;


    public AppDAOImpl(EntityManager theEntityManger) {
        entityManager = theEntityManger;

    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {

        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where instructor.id = :data", Course.class
        );
        // set argument for parameter
        query.setParameter("data", theId);

        // execute query
        List<Course> courses = query.getResultList();

        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {

        TypedQuery<Instructor> query = entityManager.createQuery(
                "SELECT i FROM Instructor i "
                + "join FETCH  i.courses "
                + "join fetch i.instructorDetail "
                + " where i.id = :data", Instructor.class
        );

        query.setParameter("data", theId);
        Instructor instructor = query.getSingleResult();

        return instructor;
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

        // get the courses

        List<Course> courses = tempInstructor.getCourses();

        // break association of all courses for the instructor
        // if not , constraint violation

        for(Course course : courses) {
            course.setInstructor(null);
        }
        //



        // delete the instructor
        entityManager.remove(tempInstructor);

    }


    // Why I have to find InstructorDetail with ID of instructor?
    // I think I can find it with its own id
    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        // retrieve the instructor
        InstructorDetail tempInstructorDetail = findInstructorDetailById(theId);

        // remove the associated object reference
        //break bi-directional link
        //

        tempInstructorDetail.getInstructor().setInstructorDetail(null);

        // delete the instructor
        entityManager.remove(tempInstructorDetail);

    }

    @Override
    @Transactional
    public void update(Instructor tempInstructor) {
        entityManager.merge(tempInstructor);
    }

    @Override
    @Transactional
    public void update(Course tempCourse) {
        entityManager.merge(tempCourse);
    }

    @Override
    public Course findCourseById(int theId) {
        return entityManager.find(Course.class, theId);
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {
        // retrieve
        Course tempCourse = entityManager.find(Course.class, theId);
        // remove
        entityManager.remove(tempCourse);
    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);

    }

    @Override
    public Course findCourseAndReviewsByCourseId(int theId) {

        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c " +
                        " Join fetch c.reviews " +
                        " where c.id = :data", Course.class);

        query.setParameter("data", theId);

        return query.getSingleResult();


    }

    @Override
    public Course findCourseAndStudentsByCourseId(int theId) {

        // create query

        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c " +
                        " Join fetch c.students " +
                        " where c.id = :data", Course.class);

        // execute query

        query.setParameter("data", theId);

        return query.getSingleResult();
    }

    @Override
    public Student findStudentsAndCourseStudentId(int theId) {
        // create query

        TypedQuery<Student> query = entityManager.createQuery(
                "select s from Student s " +
                        "Join fetch s.courses " +
                        " where s.id = :data", Student.class);

        // execute query

        query.setParameter("data", theId);

        return query.getSingleResult();

    }

    @Override
    @Transactional
    public void update(Student tempStudent) {
        entityManager.merge(tempStudent);
    }

    @Override
    @Transactional
    public void deleteStudentById(int theId) {

        Student student = entityManager.find(Student.class, theId);

        entityManager.remove(student);

    }

}

package com.heem._01_spring_jpa_hibernate_mapping.dao;

import com.heem._01_spring_jpa_hibernate_mapping.entity.Course;
import com.heem._01_spring_jpa_hibernate_mapping.entity.Instructor;
import com.heem._01_spring_jpa_hibernate_mapping.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    void update(Instructor tempInstructor);

    void update(Course course);

    Course findCourseById(int theId);

    void deleteCourseById(int theId);


}

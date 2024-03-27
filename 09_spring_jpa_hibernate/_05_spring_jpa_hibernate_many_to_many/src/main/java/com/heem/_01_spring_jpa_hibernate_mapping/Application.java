package com.heem._01_spring_jpa_hibernate_mapping;

import com.heem._01_spring_jpa_hibernate_mapping.dao.AppDAO;
import com.heem._01_spring_jpa_hibernate_mapping.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
            //createCourseAndReview(appDAO);
            //retrieveCourseReiviews(appDAO);
            //deleteCourseAndReviews(appDAO);

            //createCourseAndStudents(appDAO);

            //findCourseAndStudents(appDAO);

            //findStudentAndCourses(appDAO);

            //addMoreCouresForStudents(appDAO);

            deleteStudent(appDAO);

        };
    }

    private void deleteStudent(AppDAO appDAO) {

        int theId = 1;

        System.out.println("Student with id: " + theId);

        appDAO.deleteStudentById(theId);

        System.out.println("Done");
    }

    private void findCourseAndStudents(AppDAO appDAO) {

        int theId = 10;
        Course tempCourse = appDAO.findCourseAndStudentsByCourseId(theId);

        System.out.println("Loaded Course: " + tempCourse);
        System.out.println("Students " + tempCourse.getStudents());

        System.out.println("Done!");
    }

    private void findStudentAndCourses(AppDAO appDAO) {

        int theId = 1;

        Student tempStudent = appDAO.findStudentsAndCourseStudentId(theId);

        System.out.println("Student: " + tempStudent);
        System.out.println("Taking courses: " + tempStudent.getCourses());

        System.out.println("Done!");
    }

    private void createCourseAndStudents(AppDAO appDAO) {

        // create course
        Course tempCourse = new Course("Data Structure and Algorithms");
        Course tempCourse1 = new Course("Algorithms");
        Course tempCourse2 = new Course("Operating Systems");
        Course tempCourse3 = new Course("Concurrent and Parallel");

        // create studdent

        Student tempStudent = new Student("A", "B","awhea@asdfkas.com");
        Student tempStudent1 = new Student("C", "D","awhea@asdfkas.com");
        Student tempStudent2 = new Student("E", "F","awhea@asdfkas.com");
        Student tempStudent3 = new Student("G", "H","awhea@asdfkas.com");


        tempCourse.addStudent(tempStudent);
        tempCourse.addStudent(tempStudent1);
        tempCourse.addStudent(tempStudent2);
        appDAO.save(tempCourse);

        // can occur errors since some students already detached on database
        // 1. can solve this problem add courses on student ?
        // then save the course?
        // Nope

        // 2. I can use save(student)

        // 3. or update

        /*

        tempStudent1.addCourse(tempCourse1);
        tempStudent1.addCourse(tempCourse2);


        tempCourse1.addStudent(tempStudent1);
        tempCourse1.addStudent(tempStudent2);
        tempCourse1.addStudent(tempStudent3);


        appDAO.save(tempCourse1);
        */

    }

    private void addMoreCouresForStudents(AppDAO appDAO){

        int theId = 1;

        Course tempCourse1 = new Course("Algorithms");
        Course tempCourse2 = new Course("Operating Systems");

        Student tempStudent = appDAO.findStudentsAndCourseStudentId(theId);

        System.out.println("Adding more courses to " + tempStudent);
        tempStudent.addCourse(tempCourse1);
        tempStudent.addCourse(tempCourse2);

        appDAO.update(tempStudent);

        System.out.println("Added courses " + tempStudent.getCourses());
        System.out.println("Done");

    }
    private void createCourseAndStudents2(AppDAO appDAO) {
        Course tempCourse1 = new Course("Algorithms");

        Student tempStudent1 = new Student("C", "D","awhea@asdfkas.com");
        Student tempStudent2 = new Student("E", "F","awhea@asdfkas.com");
        Student tempStudent3 = new Student("G", "H","awhea@asdfkas.com");
        tempCourse1.addStudent(tempStudent1);
        tempCourse1.addStudent(tempStudent2);
        tempCourse1.addStudent(tempStudent3);


        appDAO.save(tempCourse1);
    }

    private void deleteCourseAndReviews(AppDAO appDAO) {

        int theId = 10;
        System.out.println("Deleting course id: " + theId);

        appDAO.deleteCourseById(theId);

        System.out.println("Done!");
    }

    private void retrieveCourseReiviews(AppDAO appDAO) {

        // get the course and review

        int theId = 10;
        Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);


        // print the course
        System.out.println(tempCourse);

        // print the reviews
        System.out.println(tempCourse.getReviews());


    }

    private void createCourseAndReview(AppDAO appDAO){
        // create aa course

        Course tempCourse = new Course("Data Structure and Algorithms");

        tempCourse.addReview(new Review("Greate Course to learn data structure"));
        tempCourse.addReview(new Review(""));
        tempCourse.addReview(new Review("sucks"));

        System.out.println("Saving the course");
        System.out.println(tempCourse);
        System.out.println(tempCourse.getReviews());

        appDAO.save(tempCourse);

        System.out.println("Done!");
    }

    private void updateCourse(AppDAO appDAO) {
        int theId = 10;

        System.out.println("Find Course's id: " + theId);

        Course tempCourse = appDAO.findCourseById(theId);

        System.out.println("tempCourse " + tempCourse);

        tempCourse.setTitle("Concurrent and Parallel");

        appDAO.update(tempCourse);

        System.out.println("After updating "+ appDAO.findCourseById(theId));


    }

    private void updateInstructor(AppDAO appDAO) {
        int theId = 1;

        System.out.println("Finding Instructo:" + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("Before Updating: " +tempInstructor);

        tempInstructor.setFirstName("Gahyeong");

        appDAO.update(tempInstructor);

        System.out.printf("After Updating" + appDAO.findCoursesByInstructorId(theId));

        System.out.println("Done");
    }

    // LAZY fetch and retrieve the courses and set it explicity
    private void findCoursesForInstructor(AppDAO appDAO){
        int theId = 1;

        System.out.println("finding instructor id " + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("tempInstructor" + tempInstructor);

        List<Course> courses = appDAO.findCoursesByInstructorId(theId);
        System.out.println("Finding courses" + courses);

        //Associate the objects
        tempInstructor.setCourses(courses);

        System.out.println("the associated courses: " + tempInstructor.getCourses());

    }


    // already fetched
    private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

        int theId = 1;
        System.out.println("finding insturctor id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

        System.out.println("tempInstructor:" + tempInstructor);
        System.out.println("the associated courses: " + tempInstructor.getCourses());
        System.out.println("Done!");

    }

    private void findInstructorWitCourses(AppDAO appDAO) {
        int theId = 1;

        System.out.println("finding insturctor id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("tempInstructor:" + tempInstructor);
        // courses lazy initialized
        System.out.println("the associated courses: " + tempInstructor.getCourses());
        System.out.println("Done!");
    }

    private void createInstructorWithCourses(AppDAO appDAO){
        Instructor tempInstructor =
                new Instructor("Heemin", "Woo", "heem6woo@gmail.com");

        InstructorDetail tempInstructorDetail =
                new InstructorDetail(
                        "http://www.heem6woo.com/youtube",
                        "Luv 2 Code !!!");

        // associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        Course tempCourse1 = new Course("Algorithms");
        Course tempCourse2 = new Course("Operating Systems");

        tempInstructor.add(tempCourse1);
        tempInstructor.add(tempCourse2);

        // save the instructor
        // Note: this will ALSO save the d etails object
        // because of CascadeType.ALL
        //
        System.out.println("Saving instructor" + tempInstructor);
        System.out.println("The course: " + tempInstructor.getCourses());
        // id is not set yet
        appDAO.save(tempInstructor);

        System.out.println("Done!");
    }

    private void createInstructor(AppDAO appDAO) {
        /*
        Instructor tempInstructor =
                new Instructor("Chad", "Darby", "darby@luv2code.com");

        InstructorDetail tempInstructorDetail =
                new InstructorDetail(
                        "http://www.luv2code.com/youtube",
                        "Luv 2 Code !!!");


         */
        Instructor tempInstructor =
                new Instructor("Heemin", "Woo", "heem6woo@gmail.com");

        InstructorDetail tempInstructorDetail =
                new InstructorDetail(
                        "http://www.heem6woo.com/youtube",
                        "Luv 2 Code !!!");

        // associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // save the instructor
        // Note: this will ALSO save the d etails object
        // because of CascadeType.ALL
        //
        System.out.println("Saving instructor" + tempInstructor);
        appDAO.save(tempInstructor);

        System.out.println("Done!");
    }

    private void findInstructor(AppDAO appDAO) {
        int theId = 1;

        System.out.println("finding instructor id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("the associated instructorDetail only: " + tempInstructor.getInstructorDetail());


    }

    private void deleteInstructor(AppDAO appDAO) {

        int theId = 1;
        System.out.println("Deleting ID: " + theId);

        appDAO.deleteInstructorById(theId);

    }

    private void deleteCourse(AppDAO appDAO) {

        int theId = 10;
        System.out.println("Deleting Course ID: " + theId);

        appDAO.deleteCourseById(theId);
    }

    private void findInstructorDetail(AppDAO appDAO) {
        //get the instructor detail object

        int theId = 2;

        InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

        // print the instructor detail

        System.out.println("tempInstructorDetail: " + tempInstructorDetail.getInstructor());


        // print the associated instructor
        System.out.println("Done");
    }

    private void deleteInstructorDetail(AppDAO appDAO){
        int theId = 5;
        System.out.println("Deleting ID: " + theId);

        appDAO.deleteInstructorDetailById(theId);


    }








}

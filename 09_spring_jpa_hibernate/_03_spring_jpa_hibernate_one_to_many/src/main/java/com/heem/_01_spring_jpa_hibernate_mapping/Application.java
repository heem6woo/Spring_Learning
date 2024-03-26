package com.heem._01_spring_jpa_hibernate_mapping;

import com.heem._01_spring_jpa_hibernate_mapping.dao.AppDAO;
import com.heem._01_spring_jpa_hibernate_mapping.entity.Course;
import com.heem._01_spring_jpa_hibernate_mapping.entity.Instructor;
import com.heem._01_spring_jpa_hibernate_mapping.entity.InstructorDetail;
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
             //createInstructor(appDAO);

            //findInstructor(appDAO);

            //deleteInstructor(appDAO);

            //findInstructorDetail(appDAO);

            //deleteInstructorDetail(appDAO);

            //createINstructorWithCourses(appDAO);

            //findInstructorWitCourses(appDAO);

            //findInstructorWithCoursesJoinFetch(appDAO);

            //updateCourse(appDAO);

            deleteCourse(appDAO);
        };
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

    private void createINstructorWithCourses(AppDAO appDAO){
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

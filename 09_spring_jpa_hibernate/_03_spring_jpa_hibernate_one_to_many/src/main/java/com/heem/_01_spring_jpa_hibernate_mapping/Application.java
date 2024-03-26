package com.heem._01_spring_jpa_hibernate_mapping;

import com.heem._01_spring_jpa_hibernate_mapping.dao.AppDAO;
import com.heem._01_spring_jpa_hibernate_mapping.entity.Course;
import com.heem._01_spring_jpa_hibernate_mapping.entity.Instructor;
import com.heem._01_spring_jpa_hibernate_mapping.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

            createINstructorWithCourses(appDAO);
        };
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

        int theId = 3;
        System.out.println("Deleting ID: " + theId);

        appDAO.deleteInstructorById(theId);

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

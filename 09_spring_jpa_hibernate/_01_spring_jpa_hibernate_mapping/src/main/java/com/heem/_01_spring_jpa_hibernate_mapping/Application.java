package com.heem._01_spring_jpa_hibernate_mapping;

import com.heem._01_spring_jpa_hibernate_mapping.dao.AppDAO;
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
             // createInstructor(appDAO);

            //findInstructor(appDAO);

            deleteInstructor(appDAO);
        };
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






}

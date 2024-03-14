package com.heem.crud;

import com.heem.crud.dao.StudentDao;
import com.heem.crud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDao studentDao) {
        return runner -> {

            //createStudent(studentDao);

            createMultiplestudent(studentDao);

            findStudent(studentDao, 1);
        };
    }

    private void createMultiplestudent(StudentDao studentDao) {

        // create multiple students
        System.out.println("Creating multiple student objects");
        Student heemin = new Student("Heemin", "Woo", "heem6woo@gmail.com");
        Student temp1 = new Student("Gildong", "Woo", "gildong@gmail.com");
        Student temp2 = new Student("Heemin", "Woo", "heem6woo@gmail.com");
        Student temp3 = new Student("Heemin", "Woo", "heem6woo@gmail.com");
        // save the students

        System.out.println("Saving the new student ... ");
        studentDao.save(heemin);
        studentDao.save(temp1);
        studentDao.save(temp2);
        studentDao.save(temp3);

        //display ids
        System.out.println("Saved student. Generated Id: " + heemin.getId());
        System.out.println("Saved student. Generated Id: " + temp1.getId());
        System.out.println("Saved student. Generated Id: " + temp2.getId());
        System.out.println("Saved student. Generated Id: " + temp3.getId());
    }


    private void createStudent(StudentDao studentDao) {
        // create student object
        System.out.println("Creating new student object");
        Student heemin = new Student("Heemin", "Woo", "heem6woo@gmail.com");

        // save the student object
        System.out.println("Saving the new student ... ");
        studentDao.save(heemin);

        // display id of the student
        System.out.println("Saved student. Generated Id: " + heemin.getId());
    }

    private void findStudent(StudentDao studentDao, int id) {
        // find  student
        System.out.println("Searching for student with ID: "+ id);
        Student found = studentDao.findById(id);

        // display student's name
        System.out.println("Student with Id: "+ id + "'s name is " + found.getFirstName() + " " + found.getLastName());

    }

}

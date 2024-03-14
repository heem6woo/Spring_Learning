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

            //findStudent(studentDao, 1);

            //queryForStudents(studentDao);

            //queryForStudentsByLastName(studentDao, "Woo");

            //updateStudent(studentDao);

            //removeStudentById(studentDao, 1);

            removeAllStudent(studentDao);

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

    private void queryForStudents(StudentDao studentDao) {
        //
        System.out.println("Find every students in the school");
        System.out.println(studentDao.findAll());
    }

    private void queryForStudentsByLastName(StudentDao studentDao, String lastName) {
        System.out.println("Find every students with lastname: " + lastName );
        for( Student student: studentDao.findByLastName(lastName)){
            System.out.println(student);
        }
    }

    private void updateStudentFirstNameById(StudentDao studentDao, int id, String firstname) {
        Student theStudent = studentDao.findById(id);

        System.out.println("Updating firstname of " + theStudent.getFirstName() + " " + theStudent.getLastName());

        theStudent.setFirstName(firstname);

        System.out.println("Updated to " + theStudent.getFirstName() + " " + theStudent.getLastName());

        studentDao.update(theStudent);
    }



    private void updateStudent(StudentDao studentDao) {

        int id = 1;
        Student theStudent = studentDao.findById(id);

        System.out.println("Updating Student");
        theStudent.setFirstName("Scooby");

        studentDao.update(theStudent);
        System.out.println(theStudent);

    }

    private void removeStudentById(StudentDao studentDao, int id) {

        System.out.println("Delete the student with ID: " + id);
        studentDao.delete(id);

    }

    private void removeAllStudent(StudentDao studentDao) {

        System.out.println("Removing every students ...");
        int numRowsDeleted = studentDao.deleteAll();

        System.out.println("Number of Rows deleted: " + numRowsDeleted);
    }
}

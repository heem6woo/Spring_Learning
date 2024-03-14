package com.heem.crud.rest;

import com.heem.crud.dao.StudentDao;
import com.heem.crud.entity.Student;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    StudentDao myStudentDao;

    // Inject dependecy using Constructor
    public StudentRestController(StudentDao studentDao) {
        myStudentDao = studentDao;
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> notFoundExceptionHandler(StudentNotFoundException ex) {
        StudentErrorResponse error = new StudentErrorResponse();

        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        error.setStatus(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> exceptionHandler(Exception ex) {
        StudentErrorResponse error = new StudentErrorResponse();

        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        error.setStatus(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


    // defines endpoist for "/students"
    @GetMapping("/students")
    public List<Student> getStudents() {
        return myStudentDao.findAll();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        Student tempStudent;

        try {
            tempStudent = myStudentDao.findById(studentId);
            return tempStudent;
        } catch (EntityNotFoundException ex) {
            throw new StudentNotFoundException("Student ID: " + studentId +" is not found!");
        }
    }

}

package com.heem.crud.rest;

import com.heem.crud.dao.StudentDao;
import com.heem.crud.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    StudentDao myStudentDao;

    // Inject dependecy using Constructor
    public StudentRestController(StudentDao studentDao) {
        myStudentDao = studentDao;
    }
    // defines endpoist for "/students"
    @GetMapping("/students")
    public List<Student> getStudents() {
        return myStudentDao.findAll();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        return myStudentDao.findById(studentId);
    }
}

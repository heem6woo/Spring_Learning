package com.heem._01_spring_mvc_thymeleaf.controller;

import com.heem._01_spring_mvc_thymeleaf.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countires;

    @GetMapping("/showStudentForm")
    public String showForm(Model model) {

        // create Student object

        Student student = new Student();

        // add a student object to model

        model.addAttribute("student", student);

        // add country list to model

        model.addAttribute("countries", countires);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student theStudent) {

        System.out.println("theStudent: "+ theStudent.getFirstName() + " " + theStudent.getLastName());
        return "student-confirmation";
    }




}

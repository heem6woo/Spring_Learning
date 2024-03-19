package com.heem._01_spring_mvc_thymeleaf.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // new controller method to show initial HTML form

    @GetMapping("/showForm")
    public String showForm() {

        return "helloworld-form";
    }
    /*
    @PostMapping("/showForm")
    public String showForm2() {

        return "helloworld-form";
    }

     */

    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    @PostMapping("/processFormVersionThree")
    public String processFormV3(@RequestParam("studentName") String theName, Model model) {

        theName = theName.toUpperCase();

        String result = "This is message from V3 " + theName;

        model.addAttribute("message", result);

        return "helloworld";
    }

    @RequestMapping("/processFormVersionTwo")
    public String processFormV2(HttpServletRequest httpRequest, Model model) {

        String theName = httpRequest.getParameter("studentName");

        theName = theName.toUpperCase();

        String result = "Yo " + theName;

        model.addAttribute("message", result);

        return "helloworld";
    }
}

package com.heem._01_spring_mvc_thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    // mapping /hello

    @GetMapping("/hello")
    public String sayHello(Model model) {
        model.addAttribute("theDate", new java.util.Date());
        return "helloworld";
    }
}

package com.heem.springboot.thymeleaf.controller;

import com.heem.springboot.thymeleaf.entity.Employee;
import com.heem.springboot.thymeleaf.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    //@Autowired
    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;

    }

    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        List<Employee> employeeList = employeeService.findAll();

        theModel.addAttribute("employees", employeeList);

        return "list-employees";
    }

    @RequestMapping("/showFormForAdd")
    

}

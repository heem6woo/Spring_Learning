package com.heem.springboot.thymeleaf.controller;

import com.heem.springboot.thymeleaf.entity.Employee;
import com.heem.springboot.thymeleaf.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Employee theEmployee = new Employee();

        theModel.addAttribute("employee", theEmployee);

        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {

        //save the employee
        employeeService.save(theEmployee);

        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel) {

        // get the employee from the service
        Employee theEmployee = employeeService.findById(theId);

        //set employee in the model to prepopulate the Form
        theModel.addAttribute("employee", theEmployee);

        // send over to our form
        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId){
        // delete the employee
        employeeService.deleteById(theId);

        // redirect to the /employees/list

        return "redirect:/employees/list";
    }
}

package com.huragan11.springboot.thymeleafdemo.controller;

import com.huragan11.springboot.thymeleafdemo.entity.Employee;
import com.huragan11.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "employees/list-employees";
    }

    @GetMapping("/showFromForAdd")
    public String showFromForAdd(Model model) {

        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employees/employee-form";
    }

}




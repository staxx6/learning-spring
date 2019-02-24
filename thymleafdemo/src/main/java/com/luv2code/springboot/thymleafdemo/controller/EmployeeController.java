package com.luv2code.springboot.thymleafdemo.controller;

import com.luv2code.springboot.thymleafdemo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private List<Employee> employees;

    @PostConstruct
    private void loadData() {
        employees = new ArrayList<>();
        employees.add(new Employee(1, "firs", "sec", "mail"));
        employees.add(new Employee(1, "asd", "seqwadc", "maqwwwwil"));
        employees.add(new Employee(1, "fqawe3rirs", "qqweesec", "maiwwwl"));
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employees);
        return "list-employees";
    }
}

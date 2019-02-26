package com.luv2code.springboot.thymleafdemo.controller;

import com.luv2code.springboot.thymleafdemo.entity.Employee;
import com.luv2code.springboot.thymleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
//    private List<Employee> employees;

//    @PostConstruct
//    private void loadData() {
//        employees = new ArrayList<>();
//        employees.add(new Employee(1, "firs", "sec", "mail"));
//        employees.add(new Employee(1, "asd", "seqwadc", "maqwwwwil"));
//        employees.add(new Employee(1, "fqawe3rirs", "qqweesec", "maiwwwl"));
//    }

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        model.addAttribute("employee", new Employee());
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees/list";
    }
}

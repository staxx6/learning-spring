package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);
        if(employee == null) {
            throw new RuntimeException("Employee with id: " + employeeId + " not found!");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        employeeService.save(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
        return employee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);
        if(employee == null) {
            throw new RuntimeException("Employee with id: " + employeeId + " not found!");
        }
        employeeService.deleteBy(employeeId);
        return "Deleted employee with id: " + employeeId;
    }
}

package com.example.employeemanagementusingspringboot.controller;

import com.example.employeemanagementusingspringboot.entity.Employee;
import com.example.employeemanagementusingspringboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping(value ="/getEmployeeDetails")
    public List<Employee> getEmployeeDetails()
    {

        return employeeService.getEmployeeDetails();
    }

    @GetMapping("/getEmployeeDetailsById/{employeecode}")
    public List<Employee>getEmployeeDetailsById(@PathVariable("employeecode") int employeecode) {
        return employeeService.getEmployeeDetailsById(employeecode);
    }
    @PutMapping(value ="/updateEmployeeDetails")
    public void updateEmployeeDetails(@RequestBody Employee employee)
    {

        employeeService.updateEmployee(employee);
    }

    @PostMapping(value ="/addEmployeeDetails")
    public void addEmployeeDetails(@RequestBody Employee employee)
    {

        employeeService.addEmployeeDetails(employee);
    }

}

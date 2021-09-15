package com.example.employeemanagementusingspringboot.service;

import com.example.employeemanagementusingspringboot.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployeeDetails();
    void updateEmployee(Employee employee);
    void addEmployeeDetails(Employee employee);
    List<Employee> getEmployeeDetailsById(int empCode);

}

package com.example.employeemanagementusingspringboot.dao;

import com.example.employeemanagementusingspringboot.entity.Employee;

import java.util.List;

public interface EmployeeDao {
     List<Employee> getEmployeeDetails();
     void updateEmployee(Employee employee);
    void addEmployeeDetails(Employee employee);
    List<Employee> getEmployeeDetailsById(int empCode);

    }

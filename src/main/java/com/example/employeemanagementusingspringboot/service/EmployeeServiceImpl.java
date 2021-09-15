package com.example.employeemanagementusingspringboot.service;

import com.example.employeemanagementusingspringboot.dao.EmployeeDao;
import com.example.employeemanagementusingspringboot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeDao employeeDao;
    @Override
    public List<Employee> getEmployeeDetails() {

        return    employeeDao.getEmployeeDetails();
    }

    @Override
    public void updateEmployee(Employee employee) {
         employeeDao.updateEmployee(employee);
    }

    @Override
    public void addEmployeeDetails(Employee employee) {
        employeeDao.addEmployeeDetails(employee);
    }

    @Override
    public List<Employee> getEmployeeDetailsById(int empCode) {
       return employeeDao.getEmployeeDetailsById(empCode);
    }


}

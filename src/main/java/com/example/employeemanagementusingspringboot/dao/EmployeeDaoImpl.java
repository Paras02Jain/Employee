package com.example.employeemanagementusingspringboot.dao;

import com.example.employeemanagementusingspringboot.entity.Employee;
import com.example.employeemanagementusingspringboot.utility.DbSession;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.util.List;

@Component
public class EmployeeDaoImpl implements EmployeeDao{
    private  Session session;
    public EmployeeDaoImpl()
    {
         session= DbSession.getSession();

    }
    @Override
    public List<Employee> getEmployeeDetails() {
        session.clear();
        session.beginTransaction();
        Query query = session.createQuery(" FROM Employee");
        @SuppressWarnings("unchecked")
		List<Employee> employeeList=query.getResultList();
        session.getTransaction().commit();

        return employeeList;
    }

    @Override
    public void updateEmployee(Employee employee) {
        session.beginTransaction();
        Query query;
        query = session.createQuery("UPDATE Employee SET employeename = :employeename "
                + ", dateofbirth = :dateofbirth , location = :location, email=:email"
                + " WHERE employeecode = :employeeCode");
        query.setParameter("employeename", employee.getEmployeename());
        query.setParameter("dateofbirth", employee.getDateofbirth());
        query.setParameter("email", employee.getEmail());
        query.setParameter("location", employee.getLocation());
        query.setParameter("employeeCode",employee.getEmployeecode());
        query.executeUpdate();
        session.getTransaction().commit();
    }

    @Override
    public void addEmployeeDetails(Employee employee) {
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
    }

    @Override
    public List<Employee> getEmployeeDetailsById(int empCode) {
        session.clear();
        session.beginTransaction();
        @SuppressWarnings("deprecation")
		Criteria criteria=session.createCriteria(Employee.class);
        criteria.add(Restrictions.eq("employeecode",empCode));
        @SuppressWarnings("unchecked")
		List<Employee> employeeList=criteria.list();
        session.getTransaction().commit();

        return employeeList;

    }


}


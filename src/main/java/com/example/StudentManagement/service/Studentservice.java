package com.example.StudentManagement.service;

import com.example.StudentManagement.model.Employee;

import java.util.List;

public interface Studentservice  {
    Employee createEmployee(Employee employee);
    Employee updateEmployee(Employee employee,long id);
    List<Employee> getEmployee();
    Employee getEmployeeById(long id);
    void deleteEmployee(long id);

}

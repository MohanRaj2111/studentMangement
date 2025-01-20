package com.example.StudentManagement.service;

import com.example.StudentManagement.exception.ExceptionHandling;
import com.example.StudentManagement.model.Employee;
import com.example.StudentManagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements Studentservice{

    private final StudentRepository studentRepository;
    public StudentServiceImp(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    @Override
    public Employee createEmployee(Employee employee) {
        return studentRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Employee existingEmployee = studentRepository.findById(id).orElseThrow(()->
                new ExceptionHandling("Employee","ID","id"));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setPhoneNumber(employee.getPhoneNumber());
        existingEmployee.setPassword(employee.getPassword());
        return studentRepository.save(existingEmployee);

    }

    @Override
    public List<Employee> getEmployee() {
        return studentRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
       return  studentRepository.findById(id).orElseThrow(()->
               new ExceptionHandling("employee","ID","id"));
    }

    @Override
    public void deleteEmployee(long id) {
        studentRepository.findById(id).orElseThrow(()-> new ExceptionHandling("employee","ID","id"));
        studentRepository.deleteById(id);
    }
}

package com.example.StudentManagement.service;

import com.example.StudentManagement.model.Employee;
import com.example.StudentManagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

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
}

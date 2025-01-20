package com.example.StudentManagement.controller;

import com.example.StudentManagement.model.Employee;
import com.example.StudentManagement.service.Studentservice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/student")
public class StudentController {

    private final Studentservice studentservice;
    public StudentController(Studentservice studentservice){
        this.studentservice = studentservice;
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Validated @RequestBody Employee employee){
        return  new ResponseEntity<Employee>(studentservice.createEmployee(employee), HttpStatus.CREATED);
    }
}

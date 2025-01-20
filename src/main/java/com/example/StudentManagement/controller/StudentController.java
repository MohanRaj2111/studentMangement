package com.example.StudentManagement.controller;

import com.example.StudentManagement.model.Employee;
import com.example.StudentManagement.service.Studentservice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("{id}")
    public  ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id ,
                                                    @Validated @RequestBody Employee employee){
        return new ResponseEntity<Employee>(studentservice.updateEmployee(employee,id),HttpStatus.OK);
    }

    @GetMapping
    public List<Employee> getEmployees(){
        return studentservice.getEmployee();
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id){
        return new ResponseEntity<Employee>(studentservice.getEmployeeById(id),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long id){
        studentservice.deleteEmployee(id);
        return new ResponseEntity<String>("Student record deleted sucesfully",HttpStatus.OK);
    }
}

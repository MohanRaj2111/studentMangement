package com.example.StudentManagement.repository;

import com.example.StudentManagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Employee,Long> {
}

package com.example.starter.starter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.starter.starter.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
}

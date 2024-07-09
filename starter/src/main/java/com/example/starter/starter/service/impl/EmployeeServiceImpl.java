package com.example.starter.starter.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.starter.starter.exception.ResourceNotFoundException;
import com.example.starter.starter.model.Employee;
import com.example.starter.starter.repository.EmployeeRepository;
import com.example.starter.starter.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        // Optional <Employee> employee = employeeRepository.findById(id);
        // if (employee.isPresent()) {
        //     return employee.get();
        // }
        // else{
        //     throw new ResourceNotFoundException("Employee","id",id);
        // }

        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Employee", "id", id));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        employeeRepository.save(existingEmployee);
        return existingEmployee;
        }

    @Override
    public void deleteEmployee(long id) {
        
        employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));

        employeeRepository.deleteById(id);
    }
    
    
}

package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {
 List<Employee>getAllEmployees();
 void SaveEmployee(Employee employee);
 Employee getEmployeeById(long id);
 void deleteEmployee(long id);
}

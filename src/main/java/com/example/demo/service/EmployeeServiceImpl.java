package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService 
{

	@Autowired
	private EmployeeRepository repository;
	
	@Override
	public List<Employee> getAllEmployees() {
		return repository.findAll();
		
		
	}

	@Override
	public void SaveEmployee(Employee employee) {
		this.repository.save(employee);
		
	}

	@Override
	public Employee getEmployeeById(long id) {
		//return repository.findById(id).orElse(null);
		Optional<Employee> optional=repository.findById(id);
		Employee employee=null;
		if(optional.isPresent())
		{
			employee=optional.get();
		}
		else
		{
			throw new RuntimeException("Employee Not Found");
		}
		
		return employee;
	}

	@Override
	public void deleteEmployee(long id) {
		this.repository.deleteById(id);
		
	}

}

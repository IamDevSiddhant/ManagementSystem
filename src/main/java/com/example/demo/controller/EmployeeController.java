package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@Controller
public class EmployeeController 
{

	@Autowired
	private EmployeeService service;
	
	@GetMapping("/")
	public String viewHomePage(Model model)
	{
		model.addAttribute("listemployees", service.getAllEmployees());
		return "index";
		
	}
	
	@GetMapping("/newEmployeeForm")
	public String newEmployeeForm(Model model)
	{
		Employee employee=new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}
	
	@PostMapping("/saveNewEmployee")
	public String saveNewEmployee(@ModelAttribute("employee")Employee employee ) 
	{
		service.SaveEmployee(employee);
		return "redirect:/";
		
	}
	
	@GetMapping("/updateForm/{id}")
	public String updateForm(@PathVariable(value="id") long id,Model model) 
	{
	Employee employee=service.getEmployeeById(id);
	model.addAttribute("employee", employee);
	return "update_employee";
	}
	
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value="id")long id)
	{
		this.service.deleteEmployee(id);
		return "redirect:/";
	}
}

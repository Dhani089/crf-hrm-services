package com.emp.employeeservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emp.employeeservice.model.Employee;
import com.emp.employeeservice.repository.EmployeeRepository;

@RestController
@CrossOrigin()
public class HelloWorldController {
	
	@Autowired
	EmployeeRepository employeerepository;

	@RequestMapping(value = "/hello" , method = RequestMethod.GET)  
	public String hello()   
	{  
		return "Hello Dhani";  
	}  
	
	@GetMapping("/emp/{id}")
	public ResponseEntity<Employee> getTutorialById(@PathVariable("id") long id) {
		Optional<Employee> tutorialData = employeerepository.findById(id);
		if (tutorialData.isPresent()) {
			return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}

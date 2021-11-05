package com.naveen.projection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naveen.projection.model.Employee;
import com.naveen.projection.repository.EmployeeRepository;
import com.naveen.projection.specification.EmployeeSpecification;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	
	 @GetMapping("/employees")
	    public  ResponseEntity<Object> findallemployees()
	    {
		 List<Employee> response;
	    	response= employeeRepository.findAll();
	    	return ResponseEntity.ok(response);
	    }
	 
	/* @GetMapping("/employeefirst/{firstname}")
	    public  ResponseEntity<Object> findByEmployeeFirstName(@PathVariable String firstname)
	    {
		 List<Employee> response;
	    	response= employeeRepository.findByFirstName(firstname,org.springframework.data.domain.Sort.by("department"));
	    	return ResponseEntity.ok(response);
	    }
	 
	 
	 @GetMapping("/employeelast/{lastname}")
	    public  ResponseEntity<Object> findbyEmployeeLastName(@PathVariable String lastname)
	    {
		 List<Employee> response;
	    	response= employeeRepository.findByLastName(lastname);
	    	return ResponseEntity.ok(response);
	    }
	 @GetMapping("/employeesfirstdept/{firstname}/{department}")
	    public  ResponseEntity<Object> findByEmployeeFirstNameAndDept(
	    		@PathVariable String firstname,
	    		@PathVariable String department)
	    {
		 List<Employee> response;
	    	response= employeeRepository.findByFirstNameAndDepartment(firstname,department);
	    	return ResponseEntity.ok(response);
	    }
	 
	 @GetMapping("/employeeslastdept/{lastname}/{department}")
	    public  ResponseEntity<Object> findByEmployeelastNameAndDept(@PathVariable String lastname,
	    		@PathVariable String department)
	    {
		 List<Employee> response;
	    	response= employeeRepository.findByLastNameAndDepartment(lastname,department);
	    	return ResponseEntity.ok(response);
	    }*/
	
	@GetMapping("/employeesfirstdept/{firstname}/{department}")
    public  ResponseEntity<Object> findByEmployeeFirstNameAndDept(
    		@PathVariable String firstname,
    		@PathVariable String department)
    {
	Specification<Employee> specs=Specification
			.where(EmployeeSpecification.hasFirstName(firstname).and(EmployeeSpecification.hasDepartment(department)));
	 List<Employee> response;
	response= employeeRepository.findAll(specs);
	return ResponseEntity.ok(response);
	
    }
	@GetMapping("/employeeslastname/{lastname}")
    public  ResponseEntity<Object> findBySEmployeeLastName(
    		@PathVariable String lastname)
    {
	Specification<Employee> specs=Specification
			.where(EmployeeSpecification.containsLastName(lastname));
	 List<Employee> response;
	response= employeeRepository.findAll(specs);
	return ResponseEntity.ok(response);
	
    }
 
}

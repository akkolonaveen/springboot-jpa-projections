package com.naveen.projection.repository;

import java.util.List;

import com.naveen.projection.model.Employee;

public interface EmployeeCustomRepository {
	
	
	List<Employee> findByFirstNameAndDepartment(String firstname, String department);

}

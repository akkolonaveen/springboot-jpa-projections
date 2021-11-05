package com.naveen.projection.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.naveen.projection.model.Employee;

@Component
public class EmployeeSpecification {
	

	
	public  static Specification<Employee> hasFirstName(String firstname)
	{
		return ((employee,cq,cb)->{
			return cb.equal(employee.get("firstName"),firstname);
		});
	}
	
	public  static Specification<Employee> containsLastName(String lastname)
	{
		return ((employee,cq,cb)->{
			return cb.like(employee.get("lastName"),"%"+lastname+"%");
		});
	}

	public  static Specification<Employee> hasDepartment(String department)
	{
		return ((employee,cq,cb)->{
			return cb.equal(employee.get("department"),department);
		});
	}
}

package com.naveen.projection.repository;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import com.naveen.projection.model.Employee;

public class EmployeeCustomRepositoryImpl implements EmployeeCustomRepository {
    @Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Employee> findByFirstNameAndDepartment(String firstname, String department) {
		

CriteriaBuilder cb = entityManager.getCriteriaBuilder();
CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
Root<Employee> employee = cq.from(Employee.class);

Predicate firstNamePredicate = cb.equal(employee.get("firstName"), firstname);
Predicate departmentpredicate = cb.equal(employee.get("department"),department);

cq.where(firstNamePredicate,departmentpredicate);

  TypedQuery<Employee> query=entityManager.createQuery(cq);
  
  return query.getResultList();
	}
	

}

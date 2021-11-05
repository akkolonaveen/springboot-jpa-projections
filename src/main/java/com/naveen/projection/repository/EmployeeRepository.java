package com.naveen.projection.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.naveen.projection.model.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Integer>,EmployeeCustomRepository,
JpaSpecificationExecutor<Employee>{
	
	
	//jpql queries
	//1.jqql query with paramter based
    @Query("select e from Employee e where e.firstName=:firstname")
	List<Employee> findByFirstName(@Param("firstname") String firstname,Sort sort);
  //1.jpql query with index based
    @Query("select e from Employee e where e.firstName=?1 and e.department=?2 ")
   	List<Employee> findByFirstNameAndDepartment(String firstname, String department);
    
    //native queries
    
//1.native queries with paramter based
    @Query( value="select * from Employee e where e.last_name=:lastname",nativeQuery = true)
	List<Employee> findByLastName(@Param("lastname") String lastname);
  //2..native queries with index based
    @Query( value="select * from Employee e where e.last_name=?1 and e.department=?2 ",nativeQuery = true)
	List<Employee> findByLastNameAndDepartment(String lastname, String department);
	
	

}

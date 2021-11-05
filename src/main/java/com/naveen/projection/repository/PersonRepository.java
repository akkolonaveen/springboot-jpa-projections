package com.naveen.projection.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.naveen.projection.model.Person;
import com.naveen.projection.projections.AddressLimited;
import com.naveen.projection.projections.PersonLimited;



public interface PersonRepository extends JpaRepository<Person, Long>{
	//1.fecthing all the data  JPQL query
	  @Query( "select p from Person p")
	  List<PersonLimited> findAllPersonsProjectedForLimitedData();
	  
//2. jpql query  with named paramters
	  @Query("select p from Person p where p.firstName = :firstName")
	  //@Query("select p.firstName,a.country from person p Natural join address a")
	  List<PersonLimited> findPersonByFirstNameProjectedForLimitedData(@Param("firstName") String firstName);
	  //3.
	// @Query( "select p.firstName ,a.country   from  Person p Inner Join Address a on p.address_id=a.id")
	 @Query( value="select p.first_name ,a.country  from  Person p Inner Join Address a on p.address_id=a.id" ,nativeQuery = true)
	 List<PersonLimited> findPersonByFirstNameAndCountryData();
	  
	  
	  //4.native query
	  @Query( value="SELECT p.id,p.last_name ,a.id , a.state  FROM  Person p Inner Join Address a on p.address_id=a.id" ,nativeQuery = true)
	  List<PersonLimited> findPersonByLastNameAndStateData();
	
	  //6. native query
	  @Modifying
	 @Query(value="UPDATE Person p SET p.first_name = ?1, p.last_name = ?2 WHERE p.id=?3",nativeQuery = true)
	  void updatePersonData(String firstName ,String lastName ,Long id);

	//7. last name and street from 2 tables native query
	 @Query( value="select p.id ,a.id,a.country,a.state,a.street from  Person p Inner Join Address a on p.address_id=a.id where p.id=?1 ",nativeQuery = true)
	List<PersonLimited> getAddressByPersonId(int id);

	   // dynamic projection can return personprojection 
	    <T> List<T> findByLastName(String lastName, Class<T> tClass);
	    

	

}

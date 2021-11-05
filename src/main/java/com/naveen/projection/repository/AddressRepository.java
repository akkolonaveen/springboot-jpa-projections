package com.naveen.projection.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.naveen.projection.model.Address;
import com.naveen.projection.projections.AddressLimited;


public interface AddressRepository extends JpaRepository<Address, Long> {
	
	//void saveAll(List<Address> read);
	
	 //1.
	  @Query(value ="SELECT a.id,a.state,a.country FROM  Address a",nativeQuery = true)
	  List<AddressLimited> findIdandStreet();
	  
	  //2..dynamic query for finding data by query
	   <T> List<T> findByCountry(String country, Class<T> tClass);

}

package com.naveen.projection.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.naveen.projection.model.Address;
import com.naveen.projection.model.Person;
import com.naveen.projection.projections.PersonLimited;
import com.naveen.projection.repository.AddressRepository;
import com.naveen.projection.repository.PersonRepository;
import com.naveen.projection.service.PersonService;
import com.naveen.projection.utils.CsvUtils;


@RestController
@RequestMapping("/api")
public class PersonProjectionController {
	
	 @Autowired
	    PersonService personService;
	    
	    @Autowired
	    PersonRepository personRepository;
	    
	   //1.fecthing the  person with address data  
	    @GetMapping("/person/address/data/")
	    public  ResponseEntity<Object> getpersonData()
	    {
	    	return personService.getPersonData();
	    }
	    //2.fetching data by firstname from 2 tables
	    @GetMapping("/person/projections/{firstname}")
	    public ResponseEntity<Object> getpersonByFirstName(@PathVariable String firstname)
	    {
	    	return personService.getPersonByFirstName(firstname);
	    }
	    
	   //3.fecthing data by 2 tables and displaying only firstname and country 
	    @GetMapping("/person/firstname/country")
	    public ResponseEntity<Object> getpersonByFirstNameAndCountry()
	    {
	    	return personService.getPersonByFirstNameCountry();
	    }
	    
	  //4.fecthing data by 2 tables and displaying only lastname and state 
	    @GetMapping("/person/lastname/state")
	    public ResponseEntity<Object> getpersonByLastNameAndState()
	    {
	    	return personService.getPersonByLastNameState();
	    }
	    
	   
	    //6.
	    @PutMapping("/person/update/")
	    public ResponseEntity<String> updatePerson(
	    		@RequestParam(value = "firstName", required = true) String firstName,
	    		@RequestParam(value = "lastName", required = true) String lastName,
	    		@RequestParam(value = "id", required = true) Long id)
	    {
	    	return personService.updatePerson(firstName,lastName,id);
	    }
	    //7.
	    @GetMapping("/person/address/{id}")
	    public ResponseEntity<Object> getAddressById(@PathVariable int id)
	    {
	    	return personService.getAddressByPersonId(id);
	    }
	    
	    //7.
	   @GetMapping("/person/{lastname}")
	   
	    public ResponseEntity<Object> getlastname(@PathVariable String lastname)
	    {
	    	return personService.getLastName(lastname);
	    }
	    
	   /* @PostMapping(value = "/upload", consumes = "text/csv")
	    public void uploadSimple(@RequestBody InputStream body) throws IOException {
	    	personRepository.saveAll(CsvUtils.read(Person.class, body));
	        
	    }

	    @PostMapping(value = "/upload", consumes = "multipart/form-data")
	    public void uploadMultipart(@RequestParam("file") MultipartFile file) throws IOException {
	    	personRepository.saveAll(CsvUtils.read(Person.class, file.getInputStream()));
	    }*/
	   
	 

}

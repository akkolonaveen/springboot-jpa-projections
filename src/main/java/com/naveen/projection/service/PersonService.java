package com.naveen.projection.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naveen.projection.projections.AddressLimited;
import com.naveen.projection.projections.PersonLimited;
import com.naveen.projection.repository.PersonRepository;


@Service
public class PersonService {
	@Autowired
	private PersonRepository  personRepository;
	
//1.fetching alll thdata
	public ResponseEntity<Object> getPersonData() {
		List<PersonLimited> response;
		 response= personRepository.findAllPersonsProjectedForLimitedData();
		 return ResponseEntity.ok(response);
	}

//2.fetching by first name
	public ResponseEntity<Object> getPersonByFirstName(String firstName) {
		// TODO Auto-generated method stub
		List<PersonLimited> response;
		//ResponseEntity<Object> response=ResponseEntity.ok(null);
		response=personRepository.findPersonByFirstNameProjectedForLimitedData(firstName);
		 return ResponseEntity.ok(response);
	}
	
	//3.fetching first nme and country name
		public ResponseEntity<Object> getPersonByFirstNameCountry() {
			 List<PersonLimited> response;
			 response= personRepository.findPersonByFirstNameAndCountryData();
			 return ResponseEntity.ok(response);
		}

	//4.
		public ResponseEntity<Object> getPersonByLastNameState() {

			List<PersonLimited> response;
			response =personRepository.findPersonByLastNameAndStateData();
			 return ResponseEntity.ok(response);
		}

		
//6.
		@Transactional
		public ResponseEntity<String> updatePerson(String firstName, String lastName, Long id) {
			// TODO Auto-generated method stub
			personRepository.updatePersonData(firstName, lastName, id);
			 return ResponseEntity.ok("updated the record with "+id);
		}
//7.
		public ResponseEntity<Object> getAddressByPersonId(int id) {
			List<PersonLimited> response;
			response= personRepository.getAddressByPersonId(id);
			 return ResponseEntity.ok(response);
		}

		
		
		public ResponseEntity<Object> getLastName(String lastname) {
			List<PersonLimited> response;
		    response= (List<PersonLimited> ) personRepository.findByLastName(lastname, PersonLimited.class);
		    return ResponseEntity.ok(response);
		    
		}

		/*public ResponseEntity<Object> getFullNameData() {
			PersonLimited response;
			response=personRepository.getFullName();
			return ResponseEntity.ok(response);
		}*/



}

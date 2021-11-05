package com.naveen.projection.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.naveen.projection.projections.AddressLimited;
import com.naveen.projection.projections.PersonLimited;
import com.naveen.projection.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	
	
	//1.
			public ResponseEntity<Object> getIdandStreet() {

				List<AddressLimited> response;
				response =addressRepository.findIdandStreet();
				 return ResponseEntity.ok(response);
			}
			
			//2.dynamic projection
			public ResponseEntity<Object> getCountryname(String country) {
				List<AddressLimited> response;
			    response= (List<AddressLimited> ) addressRepository.findByCountry(country, AddressLimited.class);
			    return ResponseEntity.ok(response);
			    
			}


}

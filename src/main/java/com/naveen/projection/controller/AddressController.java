package com.naveen.projection.controller;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.naveen.projection.model.Address;
import com.naveen.projection.repository.AddressRepository;
import com.naveen.projection.service.AddressService;
import com.naveen.projection.utils.CsvUtils;


@RestController
@RequestMapping("/api")
public class AddressController {
	

    @Autowired
    AddressService addressService;
    
    
   @GetMapping("/address/id/state")
    public ResponseEntity<Object> getIdandStreet()
    {
    	return addressService.getIdandStreet();
    }
	
   @GetMapping("/address/{country}")
   public ResponseEntity<Object> getCountry(@PathVariable String country )
   {
   	return addressService.getCountryname(country);
   }
	/* @PostMapping(value = "/upload", consumes = "text/csv")
	    public void uploadSimple1(@RequestBody InputStream body) throws IOException {
	    	addressRepository.saveAll(CsvUtils.read(Address.class, body));
	        
	    }

	    @PostMapping(value = "/upload", consumes = "multipart/form-data")
	    public void uploadMultipart1(@RequestParam("file") MultipartFile file) throws IOException {
	    	addressRepository.saveAll(CsvUtils.read(Address.class, file.getInputStream()));
	    }*/

}

package com.naveen.projection.projections;

import org.springframework.beans.factory.annotation.Value;

public interface AddressLimited {
	
	Long getId();
	
	 String getCountry(); 
	 
	 String getState();
	 
	 String getStreet();
	 
	 @Value("#{target.country.toUpperCase() + '-' + target.street.toUpperCase()}")
	String getCountryStreet();
	// @Value("#{target.country.toUpperCase()}")
	// String getc(); 
	 

}

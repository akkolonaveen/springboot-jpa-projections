package com.naveen.projection.projections;



import org.springframework.beans.factory.annotation.Value;

import com.naveen.projection.model.Address;

public interface PersonLimited {

	String getFirstName();

    String getLastName();

	Long getId();
	
	//Address getAddressCountry();
	
	// String getStreet();

	@Value("#{target.firstName.toUpperCase() + '-' + target.lastName.toUpperCase()}")
	String getFullName();
	
	

	AddressLimited getAddress();
}

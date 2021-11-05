package com.naveen.projection.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Employee {
	
	
	
	@Id
	@GeneratedValue
	private int id;
	private String firstName;
	private String  lastName;
	private String department;
	
	

}

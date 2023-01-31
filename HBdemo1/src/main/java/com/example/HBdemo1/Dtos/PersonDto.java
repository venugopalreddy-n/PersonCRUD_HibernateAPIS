package com.example.HBdemo1.Dtos;

import org.hibernate.validator.constraints.NotBlank;

import com.example.HBdemo1.model.Person;


import lombok.Data;

@Data

public class PersonDto {
     @NotBlank(message="FirstName should not be empty")//@Min(10)
	private String firstName;
	private String lastName;
	private String dob;
	public Person to()
	{
		return Person.builder()
				.firstName(firstName)
				.lastName(lastName)
				.dob(dob).build();
	}
}

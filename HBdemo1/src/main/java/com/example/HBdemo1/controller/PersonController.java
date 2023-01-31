package com.example.HBdemo1.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.HBdemo1.Dtos.PersonDto;
import com.example.HBdemo1.model.Person;
import com.example.HBdemo1.service.PersonServiceInterf;
import com.example.HBdemo1.serviceImpl.PersonServiceInterfImpl;



@RestController
public class PersonController {
 
	private static Logger logger=LoggerFactory.getLogger(PersonController.class);
	@Autowired
	PersonServiceInterfImpl personServiceInterf;
	@GetMapping("/person")
	public Person getPersonById(@RequestParam("id") int id)
	{
		return personServiceInterf.getPersonById(id);
	}
	
	@PostMapping("/person")
	public ResponseEntity createPersonStatic(@RequestBody @Valid PersonDto personDto )
	{
		personServiceInterf.createPersonStatic(personDto);
		logger.info("received object {}",personDto.getFirstName());
		return new ResponseEntity(HttpStatus.CREATED);
	}
	@PostMapping("/createPerson")
	public ResponseEntity createPerson(@RequestBody @Valid PersonDto personDto)
	{
		personServiceInterf.createPerson(personDto);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	@GetMapping("persons")
	public List<Person> getAllPersons()
	{
		return personServiceInterf.getAllPersons();
	}
	@DeleteMapping("/deletePerson")
	public void deletePerson(@RequestParam("id") int id)
	{
		 personServiceInterf.deletePerson(id);
		
	}
	
}

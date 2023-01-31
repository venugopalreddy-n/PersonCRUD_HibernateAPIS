package com.example.HBdemo1.serviceImpl;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HBdemo1.repository.PersonRepositoryInterf;
import com.example.HBdemo1.CustomException.BadRequestException;
import com.example.HBdemo1.Dtos.PersonDto;
import com.example.HBdemo1.model.Person;
import com.example.HBdemo1.service.PersonServiceInterf;
@Service
public class PersonServiceInterfImpl implements PersonServiceInterf {

	//from here we are calling repository methods
	@Autowired
	PersonRepositoryInterf personRepositoryInterf;
	@Override
	public void createPersonStatic(PersonDto personDto) {
		// TODO Auto-generated method stub
		Person person=personDto.to();
		if(person.getAge()==null)
		{
			person.setAge(calculateAgeFromDob(person.getDob()));
		}
		personRepositoryInterf.save(person);
		
	}
	public void createPerson(PersonDto personDto)
	{
		Person person=personDto.to();
		if(person.getAge()==null)
		{
			person.setAge(calculateAgeFromDob(person.getDob()));
		}
		personRepositoryInterf.save(person);
	}
	private int calculateAgeFromDob(String dob)
	{
		if(dob==null)return (Integer) null;
		LocalDate localDate=LocalDate.parse(dob);
		LocalDate currentDate=LocalDate.now();
		return Period.between(localDate, currentDate).getYears();
	}

	@Override
	public Person getPersonById(int id) {
		// TODO Auto-generated method stub
		
		return personRepositoryInterf.findById(id).orElseThrow(null);
	
		
	}

	@Override
	public void deletePerson(int id) {
		// TODO Auto-generated method stub
		personRepositoryInterf.deleteById(id);
		
	}

	@Override
	public List<Person> getAllPersons() {
		// TODO Auto-generated method stub
		
		return personRepositoryInterf.findAll();
		
	}

}

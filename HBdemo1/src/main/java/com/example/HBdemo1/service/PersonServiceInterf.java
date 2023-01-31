package com.example.HBdemo1.service;

import java.util.List;

import com.example.HBdemo1.Dtos.PersonDto;
import com.example.HBdemo1.model.Person;

public interface PersonServiceInterf {
    void createPersonStatic(PersonDto personDto);
    void createPerson(PersonDto personDto);
    Person getPersonById(int id);
    void deletePerson(int id);
    List<Person>getAllPersons();
    
}

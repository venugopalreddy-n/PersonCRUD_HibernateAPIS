package com.example.HBdemo1.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HBdemo1.model.Person;

public interface PersonRepositoryInterf extends JpaRepository<Person,Integer>{

	
}

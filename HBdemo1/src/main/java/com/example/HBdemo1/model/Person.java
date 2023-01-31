package com.example.HBdemo1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity //hibernate scan this cls and create table
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;
  private String firstName;
  private String lastName;
  private Integer age;
  private String dob;
}

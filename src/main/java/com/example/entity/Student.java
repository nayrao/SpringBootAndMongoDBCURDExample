package com.example.entity;

import javax.annotation.Generated;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "STUDENT")
@Data
public class Student {
	@Id
	private Integer id;
	private String name;
	private String city;
	private String description;

}

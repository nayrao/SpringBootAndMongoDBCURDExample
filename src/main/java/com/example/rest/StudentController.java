package com.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.repo.StudentRepository;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;

	@PostMapping("/add")
	public String addStudent(@RequestBody Student student) {
		
		Student save = this.studentRepository.save(student);
		
		return "Student added"+save.getId();
	}
}

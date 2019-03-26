package com.spring.studenthystrixservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.studenthystrixservice.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@GetMapping(value="getStudents/{school}")
	public String getStudents(@PathVariable String school){
		return studentService.getStudents(school);
	}
}

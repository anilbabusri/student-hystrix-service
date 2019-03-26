package com.spring.studenthystrixservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spring.studenthystrixservice.model.Student;

@Service
public class StudentService {
	
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod="fallBack")
	public String getStudents(String school){
		return restTemplate.getForObject("http://localhost:8081/getStudents/"+school, String.class);
	}
	
	public String fallBack(String school){
		return new Student("FallbackMethod", "Called").toString();
	}
}

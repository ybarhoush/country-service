package com.example.countryservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	
	/** 
	 * @return String
	 */
	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

}
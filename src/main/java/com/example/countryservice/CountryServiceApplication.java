package com.example.countryservice;

import com.example.countryservice.entities.Country;
import com.example.countryservice.repositories.CountryRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CountryServiceApplication {

	
	/** 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(CountryServiceApplication.class, args);
	}
	
	 
	 /** 
	  * @param repository
	  * @return CommandLineRunner
	  */
	 @Bean
	 public CommandLineRunner demoWriteToDb(CountryRepository repository) {
	   return (args) -> {
  
	 	// save new country
	 	repository.save(new Country("Finland", "FI", "Helsinki", 500000, "flag"));
		repository.save(new Country("Palestine", "PS", "Jerusalem", 700000, "flag"));
		};
	 }
}

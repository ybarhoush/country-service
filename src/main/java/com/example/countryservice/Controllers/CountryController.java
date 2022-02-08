package com.example.countryservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.countryservice.entities.Country;
import com.example.countryservice.repositories.CountryRepository;

import java.lang.Iterable;

@RestController
@RequestMapping("/db/countries")
public class CountryController {

  private final CountryRepository countryRepository;

  public CountryController(CountryRepository countryRepository) {
    this.countryRepository = countryRepository;
  }

  
  /** 
   * @return Iterable<Country>
   */
  @GetMapping()
  public Iterable<Country> getAllCountries() {
    Iterable<Country> countries = this.countryRepository.findAll();
    return countries;
  }

  
  /** 
   * @param name
   * @return Iterable<Country>
   */
  @GetMapping(path="/{name}")
  public Iterable<Country> getCountryByName(@PathVariable String name) {
    Iterable<Country> country = countryRepository.findByName(name);
    return country;
  }
}
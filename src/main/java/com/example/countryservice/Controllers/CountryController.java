package com.example.countryservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.countryservice.entities.Country;
import com.example.countryservice.repositories.CountryRepository;

import java.lang.Iterable;

@RestController
@RequestMapping("/countries")
public class CountryController {

  private final CountryRepository countryRepository;

  public CountryController(CountryRepository countryRepository) {
    this.countryRepository = countryRepository;
  }

  @GetMapping()
  public Iterable<Country> getAllCountries() {
    Iterable<Country> countries = this.countryRepository.findAll();
    return countries;
  }

  @GetMapping(path="/{name}")
  public Iterable<Country> getCountryByName(@PathVariable String name) {
    Iterable<Country> country = countryRepository.findByName(name);
    return country;
  }
}
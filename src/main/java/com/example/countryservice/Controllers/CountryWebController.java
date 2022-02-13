package com.example.countryservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import com.example.countryservice.entities.Countries;
import com.example.countryservice.entities.Country;
import com.example.countryservice.services.CountryWebService;

@RestController
@RequestMapping("/countries")
public class CountryWebController {

  @Autowired
  private CountryWebService countryWebService;
  
   @GetMapping("")
  public List<Countries> getAllCountries() {
    List<Countries> countries = this.countryWebService.findAll();
    return countries;
   }

  @GetMapping(path="/{name}")
  public Country getCountryByName(@PathVariable String name) {
    Country country = countryWebService.findByName(name);
    return country;
  }

}
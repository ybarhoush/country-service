package com.example.countryservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.countryservice.entities.CountriesAndCodesData;
import com.example.countryservice.entities.Country;
import com.example.countryservice.services.CountryWebService;

@RestController
@RequestMapping("/countries")
public class CountryWebController {

  @Autowired
  private CountryWebService countryWebService;

  
  /** 
   * @return Iterable<CountriesAndCodesData>
   */
  @GetMapping("")
  public Iterable<CountriesAndCodesData> getAllCountries() {
    Iterable<CountriesAndCodesData> countries = this.countryWebService.findAll();
      System.out.println(countries.toString());
      return countries;
   }

  
  /** 
   * @param name
   * @return Country
   */
  @GetMapping(path="/{name}")
  public Country getCountryByName(@PathVariable String name) {
    Country country = countryWebService.findByName(name);
      return country;
  }
}
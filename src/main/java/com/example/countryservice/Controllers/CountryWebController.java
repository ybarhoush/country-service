package com.example.countryservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import com.example.countryservice.entities.Countries;
import com.example.countryservice.entities.Country;
import com.example.countryservice.entities.GetResponse;
import com.example.countryservice.services.CountryWebClient;
import com.example.countryservice.services.CountryWebService;

@RestController
@RequestMapping("/countries")
public class CountryWebController {

  @Autowired
  private CountryWebService countryWebService;
  
  // @GetMapping("")
  // public List<Countries> getAllCountries() {
  //   List<Countries> countries = this.countryWebService.findAll();
  //   return countries;
  //  }

  @GetMapping("/reactive")
  public Mono<GetResponse> getAllCountriesReactive() {
    CountryWebClient CountryWebClient = new CountryWebClient();
    Mono<GetResponse> countries = CountryWebClient.consumeGet();
    return countries;

   }
   
   @GetMapping(path="")
   public ResponseEntity<List<Countries>> getAllCountries() throws Exception{
     try {
        List<Countries> countries = this.countryWebService.findAll();
        return new ResponseEntity<List<Countries>>(countries, HttpStatus.OK);
     }
     catch (HttpClientErrorException e){
       //TODO:Generate Exception
       throw countryWebService.generateCountryNotFoundException();
     }
   }

  // @GetMapping(path="/{name}")
  // public Country getCountryByName(@PathVariable String name) {
  //   Country country = countryWebService.findByName(name);
  //   return country;
  // }

  @GetMapping(path="/reactive/{name}")
  public Mono<Country> getCountryByNameReactive(@PathVariable String name) {
    CountryWebClient CountryWebClient = new CountryWebClient();
    Mono<Country> country = CountryWebClient.consumePost(name);
    return country;
  }

  @GetMapping(path="/{name}")
  public ResponseEntity<Country> getCountryByName(@PathVariable String name) throws Exception{
    try {
      Country country = countryWebService.findByName(name);
      return new ResponseEntity<Country>(country, HttpStatus.OK);
    }
    catch (HttpClientErrorException e){
      //TODO:Generate Exception
      throw countryWebService.generateCountryNotFoundException();
    }
  }
}
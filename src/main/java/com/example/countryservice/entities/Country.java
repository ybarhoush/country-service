package com.example.countryservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
@JsonPropertyOrder({
  "name",
  "country_code",
  "capital",
  "population",
  "flag_file_url"
})
public class Country {

  private String name;
  private String countryCode;
  private String capital;
  private Integer population;
  private String flagFileUrl;

  public Country(String name, String countryCode, String capital, Integer population, String flagFileUrl) {
    this.name = name;
    this.countryCode = countryCode;
    this.capital = capital;
    this.population = population;
    this.flagFileUrl = flagFileUrl;
  }

  protected Country() {

  }

  public String toString() {
    return String.format(
        "Country[name='%s', countryCode='%s', capital='%s, population='%s, flagFileUrl='%s']",
        name, countryCode, capital, population, flagFileUrl);
  }
  
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("country_code")
  public String getCountryCode() {
    return countryCode;
  }
  
  @JsonProperty("capital")
  public String getCapital(){
    return capital;
  }
  
  @JsonProperty("population")
  public Integer getPopulation(){
    return population;
  }

  @JsonProperty("flag_file_url")
  public String getFlagFileUrl(){
    return flagFileUrl;
  }
}
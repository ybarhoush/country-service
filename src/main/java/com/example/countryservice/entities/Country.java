package com.example.countryservice.entities;

public class Country {

  private Long id;
  private String name;
  private String countryCode;
  private String capital;
  private Integer population;
  private String flagFileUrl;


  protected Country() {}

  public Country(String name, String countryCode, String capital, Integer population, String flagFileUrl) {
    this.name = name;
    this.countryCode = countryCode;
    this.capital = capital;
    this.population = population;
    this.flagFileUrl = flagFileUrl;
  }

  @Override
  public String toString() {
    return String.format(
        "Country[id=%d, name='%s', countryCode='%s', capital='%s, population='%s, flagFileUrl='%s']",
        id, name, countryCode, capital, population, flagFileUrl);
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public String getCapital(){
    return capital;
  }

  public Integer getPopulation(){
    return population;
  }

  public String getFlagFileUrl(){
    return flagFileUrl;
  }
}
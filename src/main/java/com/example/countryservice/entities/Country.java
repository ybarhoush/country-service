package com.example.countryservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Country {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
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

  
  /** 
   * @return String
   */
  @Override
  public String toString() {
    return String.format(
        "Country[id=%d, name='%s', countryCode='%s', capital='%s, population='%s, flagFileUrl='%s']",
        id, name, countryCode, capital, population, flagFileUrl);
  }

  
  /** 
   * @return Long
   */
  public Long getId() {
    return id;
  }

  
  /** 
   * @return String
   */
  public String getName() {
    return name;
  }

  
  /** 
   * @return String
   */
  public String getCountryCode() {
    return countryCode;
  }

  
  /** 
   * @return String
   */
  public String getCapital(){
    return capital;
  }

  
  /** 
   * @return Integer
   */
  public Integer getPopulation(){
    return population;
  }

  
  /** 
   * @return String
   */
  public String getFlagFileUrl(){
    return flagFileUrl;
  }
}
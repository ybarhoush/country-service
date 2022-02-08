package com.example.countryservice.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PopulationData {

  private String country;
  private String code;
  private String iso3;
  private List<PopulationCounts> populationCounts;

  
  /** 
   * @return String
   */
  public String getCountry() {
      return country;
  }

  
  /** 
   * @param country
   */
  public void setCountry(String country) {
      this.country = country;
  }

  
  /** 
   * @return String
   */
  public String getCode() {
      return code;
  }

  
  /** 
   * @param code
   */
  public void setCode(String code) {
      this.code = code;
  }

  
  /** 
   * @return String
   */
  public String getIso3() {
      return iso3;
  }

  
  /** 
   * @param iso3
   */
  public void setIso3(String iso3) {
      this.iso3 = iso3;
  }

  
  /** 
   * @return List<PopulationCounts>
   */
  public List<PopulationCounts> getPopulationCounts() {
      return populationCounts;
  }

  
  /** 
   * @param populationCounts
   */
  public void setPopulationCounts(List<PopulationCounts> populationCounts) {
      this.populationCounts = populationCounts;
  }

  
  /** 
   * @return String
   */
  @Override
  public String toString() {
      return "{" +
              "country='" + country + '\'' +
              ", code='" + code + '\'' +
              ", iso3=" + iso3 +
              ", populationCounts='" + populationCounts + '\'' +
              '}';
  }
}
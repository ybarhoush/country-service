package com.example.countryservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PopulationCounts {

  private String year;
  private String value;

  
  /** 
   * @return String
   */
  public String getYear() {
      return year;
  }

  
  /** 
   * @param year
   */
  public void setYear(String year) {
      this.year = year;
  }

  
  /** 
   * @return String
   */
  public String getValue() {
      return value;
  }

  
  /** 
   * @param value
   */
  public void setValue(String value) {
      this.value = value;
  }


  
  /** 
   * @return String
   */
  @Override
  public String toString() {
      return "{" +
              "year='" + year + '\'' +
              ", value='" + value + '\'' +
              '}';
  }
}
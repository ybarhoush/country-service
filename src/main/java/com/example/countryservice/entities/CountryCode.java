package com.example.countryservice.entities;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryCode {

  private String msg;
  private Boolean error;
  private String countryCode;

  
  /** 
   * @return String
   */
  public String getMsg() {
      return msg;
  }

  
  /** 
   * @param msg
   */
  public void setMsg(String msg) {
      this.msg = msg;
  }

  
  /** 
   * @return Boolean
   */
  public Boolean getError() {
      return error;
  }

  
  /** 
   * @param error
   */
  public void setError(Boolean error) {
      this.error = error;
  }

  
  /** 
   * @return String
   */
  public String getCountryCode() {
      return countryCode;
  }

  
  /** 
   * @param countryCode
   */
  public void setCountryCode(String countryCode) {
      this.countryCode = countryCode;
  }

  
  /** 
   * @return String
   */
  @Override
  public String toString() {
      return "CountryCode{" +
              " msg='" + msg + '\'' +
              ", error='" + error + '\'' +
              ", countryCode=" + countryCode +
              '}';
  }

  
  /** 
   * @param data
   */
  @JsonProperty(value = "data")
  private void unpackFlagFileUrlFromNestedObject(Map<String, String> data) {
    countryCode = data.get("Iso2");
  }
}
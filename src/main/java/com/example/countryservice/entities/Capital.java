package com.example.countryservice.entities;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Capital {

  private String msg;
  private Boolean error;
  private String capital;

  public Capital() {
  }


  
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
  public String getCapital() {
    return this.capital;
  }

  
  /** 
   * @param capital
   */
  public void setCapital(String capital) {
    this.capital = capital;
  }

  
  /** 
   * @return String
   */
  @Override
  public String toString() {
      return "Capital{" +
              " msg='" + msg + '\'' +
              ", error='" + error + '\'' +
              ", capital=" + capital +
              '}';
  }
  
  
  /** 
   * @param data
   */
  @JsonProperty("data")
  private void unpackCapitalFromNestedObject(Map<String, String> data) {
    capital = data.get("capital");
  }

}
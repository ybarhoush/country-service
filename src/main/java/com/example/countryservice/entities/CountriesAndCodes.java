package com.example.countryservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountriesAndCodes {

  private String msg;
  private Boolean error;
  private Iterable<CountriesAndCodesData> data;

  
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
   * @return Iterable<CountriesAndCodesData>
   */
  public Iterable<CountriesAndCodesData> getData() {
      return data;
  }

  
  /** 
   * @param data
   */
  public void setCountriesData(Iterable<CountriesAndCodesData> data) {
      this.data = data;
  }

  
  /** 
   * @return String
   */
  @Override
  public String toString() {
      return "Countries{" +
              " msg='" + msg + '\'' +
              ", error='" + error + '\'' +
              ", data=" + data +
              '}';
  }

}
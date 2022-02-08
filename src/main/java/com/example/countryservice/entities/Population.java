package com.example.countryservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Population {

  private String msg;
  private Boolean error;
  private PopulationData data;

  
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
   * @return PopulationData
   */
  public PopulationData getData() {
      return data;
  }

  
  /** 
   * @param data
   */
  public void setPopulationData(PopulationData data) {
      this.data = data;
  }

  
  /** 
   * @return String
   */
  @Override
  public String toString() {
      return "Population{" +
              " msg='" + msg + '\'' +
              ", error='" + error + '\'' +
              ", data=" + data +
              '}';
  }

}
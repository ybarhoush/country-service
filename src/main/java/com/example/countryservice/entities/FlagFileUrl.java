package com.example.countryservice.entities;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FlagFileUrl {

  private String msg;
  private Boolean error;
  private String flagFileUrl;

  public FlagFileUrl() {
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
  public String getFlagFileUrl() {
    return this.flagFileUrl;
  }

  
  /** 
   * @param flagFileUrl
   */
  public void setFlagFileUrl(String flagFileUrl) {
    this.flagFileUrl = flagFileUrl;
  }

  
  /** 
   * @return String
   */
  @Override
  public String toString() {
    return "FlagFileUrl{" +
    " msg='" + msg + '\'' +
    ", error='" + error + '\'' +
    ", flagFileUrl=" + flagFileUrl +
    '}';
  }

  
  /** 
   * @param data
   */
  @JsonProperty(value = "data")
  private void unpackFlagFileUrlFromNestedObject(Map<String, String> data) {
    flagFileUrl = data.get("flag");
  }
}
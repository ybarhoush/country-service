package com.example.countryservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountriesAndCodesData {

    private String name;
    // private String iso2;
    private String iso3;

    
    /** 
     * @return String
     */
    @JsonProperty("name")
    public String getCountries() {
        return name;
    }

    
    /** 
     * @param name
     */
    public void setCountries(String name) {
        this.name = name;
    }

    // @JsonProperty("Iso2")
    // public String getIso2() {
    //     return iso2;
    // }

    // public void setIso2(String iso2) {
    //     this.iso2 = iso2;
    // }

    @JsonProperty("country_code")
    public String getIso3() {
        return iso3;
    }

    
    /** 
     * @param iso3
     */
    @JsonProperty("Iso3")
    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }


    
    /** 
     * @return String
     */
    @Override
    public String toString() {
    return "{" +
            "name='" + name + '\'' +
            // ", iso2='" + iso2 + '\'' +
            // ", iso3='" + iso2 + '\'' +
            '}';
  }
}
package com.example.countryservice.entities;

//https://www.baeldung.com/jackson-annotations#1-jsonproperty
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
  "name",
  "country_code",
})
public class Countries {

  private String name;
  private String countryCode;


  public Countries(String name, String countryCode) {
    this.name = name;
    this.countryCode = countryCode;
  }

  protected Countries() {

  }

  @Override
  public String toString() {
    return String.format(
        "Country[name='%s', countryCode='%s']",
        name, countryCode);
  }

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public String setName() {
    return this.name;
  }

  @JsonProperty("country_code")
  public String getCountryCode() {
    return countryCode;
  }

}
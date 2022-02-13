package com.example.countryservice.entities;

import java.util.List;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
    "name",
    "Iso2",
    "capital",
    "populationCounts",
    "flag"
})
@Generated("jsonschema2pojo")
// PostResponse data Pojo; Get single country and its code, capital flag, population (from populationCounts) data
public class PostResponseData {

    private String name;
    private String iso2;
    private String capital;
    private String flag;
    private List<PopulationCount> populationCounts;

    @JsonProperty("name")
    public String getCountry() {
        return name;
    }

    @JsonProperty("name")
    public void setCountry(String name) {
        this.name = name;
    }

    @JsonProperty("country_code")
    public String getIso2() {
        return iso2;
    }

    @JsonProperty("Iso2")
    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    @JsonProperty("capital")
    public String getCapital() {
        return capital;
    }

    @JsonProperty("capital")
    public void setCapital(String capital) {
        this.capital = capital;
    }

    @JsonProperty("population")
    public List<PopulationCount> getPopulationCounts() {
        return populationCounts;
    }

    @JsonProperty("populationCounts")
    public void setPopulationCounts(List<PopulationCount> populationCounts) {
        this.populationCounts = populationCounts;
    }

    @JsonProperty("flag")
    public String getFlag() {
        return flag;
    }

    @JsonProperty("flag")
    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PostResponseData.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("country");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');

        sb.append("Iso2");
        sb.append('=');
        sb.append(((this.iso2 == null)?"<null>":this.iso2));
        sb.append(',');

        sb.append("capital");
        sb.append('=');
        sb.append(((this.capital == null)?"<null>":this.capital));
        sb.append(',');

        sb.append("flag");
        sb.append('=');
        sb.append(((this.flag == null)?"<null>":this.flag));
        sb.append(',');

        sb.append("populationCounts");
        sb.append('=');
        sb.append(((this.populationCounts == null)?"<null>":this.populationCounts));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}

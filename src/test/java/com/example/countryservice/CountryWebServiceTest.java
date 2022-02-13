package com.example.countryservice;

import com.example.countryservice.services.CountryWebService;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CountryWebServiceTest {

	@Autowired
    CountryWebService countryWebService;

	String requestJson1 = "{\"country\":\"Nigeria\"}";
	String requestJson2 = "{\"iso2\":\"NG\"}";

    String capitalUri = "https://countriesnow.space/api/v0.1/countries/capital";
    String populationUri = "https://countriesnow.space/api/v0.1/countries/population";
    String flahUri = "https://countriesnow.space/api/v0.1/countries/flag/images";
    String nameAndCountryUri = "https://countriesnow.space/api/v0.1/countries/iso";

    @Test
    void consumeName() {
        assertEquals( "Nigeria", countryWebService.consumePost(requestJson1, nameAndCountryUri).getData().getCountry());
    }

    @Test
    void consumeCountryCode() {
        assertEquals( "NG", countryWebService.consumePost(requestJson1, nameAndCountryUri).getData().getIso2());
    }

    @Test
    void consumeCapital() {
        assertEquals( "Abuja", countryWebService.consumePost(requestJson1, capitalUri).getData().getCapital());
    }

	@Test
    void consumePopulation() {
        assertEquals( 195874740, countryWebService.consumePost(requestJson1, populationUri).getData().getPopulationCounts().get(58).getValue());
    }
	@Test
    void consumeFlagFileUrl() {
        assertEquals( "https://upload.wikimedia.org/wikipedia/commons/7/79/Flag_of_Nigeria.svg", countryWebService.consumePost(requestJson2, flahUri).getData().getFlag());
    }
}
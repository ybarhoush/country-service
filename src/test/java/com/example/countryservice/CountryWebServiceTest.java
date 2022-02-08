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

    @Test
    void consumeCapital() {
        assertEquals( "Abuja", countryWebService.consumeCapital(requestJson1));
    }

	@Test
    void consumeCountryCode() {
        assertEquals( "NG", countryWebService.consumeCountryCode(requestJson1));
    }

	@Test
    void consumePopulation() {
        assertEquals( 195874740, countryWebService.consumePopulation(requestJson1));
    }
	@Test
    void consumeFlagFileUrl() {
        assertEquals( "https://upload.wikimedia.org/wikipedia/commons/7/79/Flag_of_Nigeria.svg", countryWebService.consumeFlagFileUrl(requestJson2));
    }
}
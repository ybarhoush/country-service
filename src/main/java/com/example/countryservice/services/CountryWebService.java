package com.example.countryservice.services;

import com.example.countryservice.entities.Capital;
import com.example.countryservice.entities.CountriesAndCodes;
import com.example.countryservice.entities.CountriesAndCodesData;
import com.example.countryservice.entities.Country;
import com.example.countryservice.entities.CountryCode;
import com.example.countryservice.entities.FlagFileUrl;
import com.example.countryservice.entities.Population;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CountryWebService implements CountryWebServiceInterface 
{

	private final RestTemplate restTemplate;
    //https://docs.spring.io/spring-boot/docs/2.0.x/reference/html/boot-features-resttemplate.html
	public CountryWebService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

    
    /** 
     * @return Iterable<CountriesAndCodesData>
     */
    public Iterable<CountriesAndCodesData> findAll() {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
	
		String uri = "https://countriesnow.space/api/v0.1/countries/iso";

		CountriesAndCodes data = restTemplate.getForObject(uri, CountriesAndCodes.class);

		System.out.println(data.getData());
		return data.getData();
    }

    
    /** 
     * @param name
     * @return Country
     */
    public Country findByName(String name) {
        String requestJson1 = "{\"country\":\"" + name + "\"}";
        String countryCode = consumeCountryCode(requestJson1);
        String requestJson2 = "{\"iso2\":\"" + countryCode + "\"}";
        Country newCountry = new Country(name, consumeCountryCode(requestJson1), consumeCapital(requestJson1), consumePopulation(requestJson1), consumeFlagFileUrl(requestJson2));
        System.out.println(newCountry.toString());
        return newCountry;
    }

	
    /** 
     * @param requestJson
     * @return Integer
     */
    public Integer consumePopulation(String requestJson) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    
        String uri = "https://countriesnow.space/api/v0.1/countries/population";
        //String requestJson = "{\"country\":\"Nigeria\"}";
    
        HttpEntity<String> httpEntity = new HttpEntity<String>(requestJson, headers);
    
        Population data = restTemplate.postForObject(uri, httpEntity, Population.class);

        System.out.println(data.getData().getPopulationCounts().get(58).getValue());
        return Integer.valueOf(data.getData().getPopulationCounts().get(58).getValue());
	}
    
    
    /** 
     * @param requestJson
     * @return String
     */
    public String consumeCountryCode(String requestJson) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    
        String uri = "https://countriesnow.space/api/v0.1/countries/iso";
        //String requestJson = "{\"country\":\"Nigeria\"}";
    
        HttpEntity<String> httpEntity = new HttpEntity<String>(requestJson, headers);
    
        CountryCode data = restTemplate.postForObject(uri, httpEntity, CountryCode.class);

        System.out.println(data.getCountryCode());
        System.out.println(data.toString());
        return data.getCountryCode();
    }

    
    /** 
     * @param requestJson
     * @return String
     */
    public String consumeCapital(String requestJson) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    
        String uri = "https://countriesnow.space/api/v0.1/countries/capital";
        //String requestJson = "{\"country\":\"Nigeria\"}";
    
        HttpEntity<String> httpEntity = new HttpEntity<String>(requestJson, headers);
    
        Capital data = restTemplate.postForObject(uri, httpEntity, Capital.class);

        System.out.println(data.getCapital());
        System.out.println(data.toString());
        return data.getCapital();
    } 

    
    /** 
     * @param requestJson
     * @return String
     */
    public String consumeFlagFileUrl(String requestJson) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    
        String uri = "https://countriesnow.space/api/v0.1/countries/flag/images";
        //String requestJson = "{\"iso2\":\"NG\"}";
    
        HttpEntity<String> httpEntity = new HttpEntity<String>(requestJson, headers);
    
        FlagFileUrl data = restTemplate.postForObject(uri, httpEntity, FlagFileUrl.class);

        System.out.println(data.getFlagFileUrl());
        System.out.println(data.toString());
        return data.getFlagFileUrl();
    }
    
}

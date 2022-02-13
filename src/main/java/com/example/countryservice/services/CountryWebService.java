package com.example.countryservice.services;

import java.util.List;
import java.util.stream.Collectors;

import com.example.countryservice.entities.Countries;
import com.example.countryservice.entities.Country;
import com.example.countryservice.entities.GetResponseData;
import com.example.countryservice.entities.GetResponse;
import com.example.countryservice.entities.PopulationCount;
import com.example.countryservice.entities.PostResponse;

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

    public List<Countries> findAll() {
	
		String uri = "https://countriesnow.space/api/v0.1/countries/iso";
		
        List<GetResponseData> countries = consumeGet(uri).getData();

        List<Countries> countriesList = countries
            .stream()
            .map(Datum -> new Countries(Datum.getName(), Datum.getIso2()))
            .collect(Collectors.toList());

		return countriesList;
    }

    public Country findByName(String name) {

        String capitalUri = "https://countriesnow.space/api/v0.1/countries/capital";
        String populationUri = "https://countriesnow.space/api/v0.1/countries/population";
        String flahUri = "https://countriesnow.space/api/v0.1/countries/flag/images";
        String nameAndCountryUri = "https://countriesnow.space/api/v0.1/countries/iso";

        String requestJson1 = "{\"country\":\"" + name + "\"}";

        String countryName = consumePost(requestJson1, nameAndCountryUri).getData().getCountry();
        String countryCode = consumePost(requestJson1, nameAndCountryUri).getData().getIso2();
        String capital = consumePost(requestJson1, capitalUri).getData().getCapital();

        List<PopulationCount> populationCounts = consumePost(requestJson1, populationUri).getData().getPopulationCounts();
        Integer population = populationCounts.get(58).getValue();

        String requestJson2 = "{\"iso2\":\"" + countryCode + "\"}";

        String flagFileUrl = consumePost(requestJson2, flahUri).getData().getFlag();

        Country newCountry = new Country(countryName, countryCode, capital, population, flagFileUrl);
        System.out.println(newCountry.toString());
        return newCountry;
    }

    public PostResponse consumePost(String requestJson, String uri) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity = new HttpEntity<String>(requestJson, headers);
        PostResponse data = restTemplate.postForObject(uri, httpEntity, PostResponse.class);
        return data;
    }

    public GetResponse consumeGet(String uri) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        GetResponse data = restTemplate.getForObject(uri, GetResponse.class);
        return data;
    }
  
}

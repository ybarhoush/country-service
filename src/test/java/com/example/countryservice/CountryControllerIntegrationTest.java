package com.example.countryservice;

import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import com.example.countryservice.entities.Countries;
import com.example.countryservice.entities.Country;
import com.example.countryservice.entities.GetResponse;
import com.example.countryservice.entities.PostResponse;
import com.example.countryservice.services.CountryWebClient;
import com.example.countryservice.services.CountryWebService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


@SpringBootTest(classes = CountryServiceApplication.class)
public class CountryControllerIntegrationTest {

    // @Autowired
    // private WebTestClient testClient;

    // @MockBean
    // private CountryWebClient countryRepository;

    // @Test
    // public void givenCountryName_whenGetCountryByName_thenCorrectCountry() {

    //     Country country = new Country("Nigeria", "NG", "Abuja", 195874740, "https://upload.wikimedia.org/wikipedia/commons/7/79/Flag_of_Nigeria.svg");
        
    //     given(countryRepository.consumePost("Nigeria")).willReturn(Mono.just(country));

    //     testClient.get()
    //         .uri("/countries/reactive/Nigeria")
    //         .exchange()
    //         .expectStatus()
    //         .isOk()
    //         .expectBody(Country.class)
    //         .isEqualTo(country);
    // }

	// @Test
    // public void whenGetAllCountrys_thenCorrectCountrys() {

    //     Object countries;
    //     Mono<GetResponse> countriesMono = Mono.just(countries);

    //     given(countryRepository.consumeGet()).willReturn(countriesMono);
        
    //     testClient.get()
    //         .uri("/countries/reactive")
    //         .exchange()
    //         .expectStatus()
    //         .isOk()
    //         .expectBodyList(GetResponse.class)
    //         //.hasSize()
    //         .isEqualTo(countriesMono);
    // }
}
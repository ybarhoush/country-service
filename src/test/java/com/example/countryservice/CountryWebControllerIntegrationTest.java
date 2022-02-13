package com.example.countryservice;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import com.example.countryservice.controllers.CountryWebController;
import com.example.countryservice.entities.Countries;
import com.example.countryservice.services.CountryWebService;

import org.junit.jupiter.api.Test;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(value = CountryWebController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
public class CountryWebControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CountryWebService service;

    @Test
    //ToDO: fix this test
    public void givenCountries_whenGetCountries_thenReturnJsonArray() throws Exception {
		Countries countries1 = new Countries("Nigerias", "NG");
        //Countries countries2 = new Countries("Albania", "AL");

        List<Countries> allCountries = Arrays.asList(countries1);

        given(service.findAll()).willReturn(allCountries);

        mvc.perform(get("/countries/")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(1)))
            .andExpect(jsonPath("$[0].name", is(countries1.getName())));
        verify(service, VerificationModeFactory.times(1)).findAll();
        reset(service);
    }

}
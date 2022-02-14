package com.example.countryservice.services;

import com.example.countryservice.entities.Country;
import com.example.countryservice.entities.GetResponse;
import com.example.countryservice.entities.PostResponse;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;
import reactor.util.function.Tuple4;

public class CountryWebClient {
    
    WebClient client = WebClient.create("https://countriesnow.space/api/v0.1/countries");
    
    public Mono<GetResponse> consumeGet() {
        
        Mono<GetResponse> countriesMono = client
            .get()
            .uri("/iso")
            .retrieve()
            .bodyToMono(GetResponse.class);
            
        return countriesMono;
    }
    
     public Mono<Country> consumePost(String name) {
        String requestJson1 = "{\"country\":\""+name+"\"}";
        //TODO: Find a better way
        String requestJson2 = "{\"iso2\":\""+ consumePostCountryCode(name) +"\"}";

        Mono<PostResponse> countryCapitalMono = client
            .post()
            .uri("/capital")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(requestJson1)
            .retrieve()
            .bodyToMono(PostResponse.class);
        Mono<PostResponse> countryIsoMono = client
            .post()
            .uri("/iso")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(requestJson1)
            .retrieve()
            .bodyToMono(PostResponse.class);
        Mono<PostResponse> countryPopulationMono = client
            .post()
            .uri("/population")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(requestJson1)
            .retrieve()
            .bodyToMono(PostResponse.class);
        Mono<PostResponse> countryFlagMono = client
            .post()
            .uri("/flag/images")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(requestJson2)
            .retrieve()
            .bodyToMono(PostResponse.class);
        
        Mono<Tuple4<PostResponse, PostResponse, PostResponse, PostResponse>> merged = Mono.zip(countryCapitalMono, countryIsoMono, countryPopulationMono, countryFlagMono);
        return merged
            .map(Data -> new Country(
                Data.getT1().getData().getCountry(),
                Data.getT1().getData().getCapital(),
                Data.getT2().getData().getIso2(),
                Data.getT3().getData().getPopulationCounts().get(58).getValue(),
                Data.getT4().getData().getFlag()
            ));  
    }

    public String consumePostCountryCode(String name) {
        String requestJson1 = "{\"country\":\""+name+"\"}";
        Mono<PostResponse> countryIsoMono = client
            .post()
            .uri("/iso")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(requestJson1)
            .retrieve()
            .bodyToMono(PostResponse.class);
        return countryIsoMono
            .map(Data -> new String(Data.getData().getIso2()))
            .block();
    }
}
package com.example.countryservice.services;

import com.example.countryservice.entities.CountriesAndCodesData;
import com.example.countryservice.entities.Country;

public interface CountryWebServiceInterface
{
	Iterable<CountriesAndCodesData> findAll();

	Country findByName(String name);

}
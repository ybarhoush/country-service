package com.example.countryservice.services;

import java.util.List;

import com.example.countryservice.entities.Countries;
import com.example.countryservice.entities.Country;

public interface CountryWebServiceInterface
{
	List<Countries> findAll();

	Country findByName(String name);

}
package com.example.countryservice.repositories;

import java.util.List;

import com.example.countryservice.entities.Country;

import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long> {

    public List<Country> findByName(String name);

}
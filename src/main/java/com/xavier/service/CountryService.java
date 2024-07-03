package com.xavier.service;

import java.util.List;

import com.xavier.model.Country;

public interface CountryService {
    List<Country> findAll();
    Country findById(Long id);
    Country create(Country country);
    Country update(Long id, Country country);
    void delete(Long id);
}

package com.xavier.service.impl;

import java.util.List;

import com.xavier.model.Country;
import com.xavier.repository.CountryRepository;
import com.xavier.service.CountryService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CountryServiceImpl implements CountryService {

    @Inject
    CountryRepository countryRepository;

    @Override
    public List<Country> findAll() {
        return countryRepository.listAll();
    }

    @Override
    public Country findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    @Transactional
    public Country create(Country country) {
        countryRepository.persist(country);
        return country;
    }

    @Override
    @Transactional
    public Country update(Long id, Country country) {
        Country countryToUpdate = countryRepository.findById(id);
        countryToUpdate.setCountryName(country.getCountryName());
        countryToUpdate.setCountryCode(country.getCountryCode());
        countryRepository.persist(countryToUpdate);
        return countryToUpdate;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}

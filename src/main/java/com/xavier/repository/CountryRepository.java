package com.xavier.repository;

import com.xavier.model.Country;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CountryRepository implements PanacheRepository<Country> {
    
}

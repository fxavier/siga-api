package com.xavier.repository;

import com.xavier.model.Mae;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MaeRepository implements PanacheRepository<Mae> {

    public Mae findByName(String nome) {
        return find("nome", nome).firstResult();
    }
    
}

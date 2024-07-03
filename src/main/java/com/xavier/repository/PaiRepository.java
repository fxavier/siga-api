package com.xavier.repository;

import com.xavier.model.Pai;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PaiRepository implements PanacheRepository<Pai> {

    public Pai findByNome(String nome) {
        return find("nome", nome).firstResult();
    }
    
}

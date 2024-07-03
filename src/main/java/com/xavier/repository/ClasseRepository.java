package com.xavier.repository;

import java.util.Optional;

import com.xavier.model.Classe;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClasseRepository implements PanacheRepository<Classe> {

    public Optional<Classe> findByIdOptional(Integer classeId) {
        return find("id", classeId).firstResultOptional();
    }

    public Classe findById(Integer classeId) {
        return find("id", classeId).firstResult();
    }
    
}

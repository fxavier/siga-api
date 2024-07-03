package com.xavier.repository;

import java.util.Optional;

import com.xavier.model.Turma;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TurmaRepository implements PanacheRepository<Turma> {

    public Optional<Turma> findByIdOptional(Integer turmaId) {
        return find("id", turmaId).firstResultOptional();
    }
    
}

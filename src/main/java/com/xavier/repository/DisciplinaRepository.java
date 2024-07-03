package com.xavier.repository;

import com.xavier.model.Disciplina;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DisciplinaRepository implements PanacheRepository<Disciplina> {
    
}

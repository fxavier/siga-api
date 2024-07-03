package com.xavier.repository;

import com.xavier.model.Matricula;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MatriculaRepository implements PanacheRepository<Matricula> {
    
}

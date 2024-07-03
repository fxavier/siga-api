package com.xavier.repository;

import com.xavier.model.Inscricao;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InscricaoRepository implements PanacheRepository<Inscricao> {
    
}

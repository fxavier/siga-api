package com.xavier.repository;

import com.xavier.model.Documento;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DocumentoRepository implements PanacheRepository<Documento> {
    
}

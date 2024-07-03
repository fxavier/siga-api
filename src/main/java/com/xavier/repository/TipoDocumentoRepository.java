package com.xavier.repository;

import com.xavier.model.TipoDocumento;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TipoDocumentoRepository implements PanacheRepository<TipoDocumento> {

    public TipoDocumento findByDescricao(String descricao) {
        return find("descricao", descricao).firstResult();
    }
    
}

package com.xavier.repository;

import com.xavier.model.Professor;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProfessorRepository implements PanacheRepository<Professor> {

    public List<Professor> findByIds(List<Long> ids) {
        return list("id in ?1", ids);
    }
    
}

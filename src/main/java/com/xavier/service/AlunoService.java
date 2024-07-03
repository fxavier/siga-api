package com.xavier.service;

import com.xavier.dto.AlunoDTO;
import com.xavier.repository.filter.AlunoFilter;

import java.util.List;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@ApplicationScoped
public interface AlunoService {

    AlunoDTO create(@Valid AlunoDTO alunoDTO);
    AlunoDTO update(@NotNull Long id, @Valid AlunoDTO alunoDTO);
    AlunoDTO findById(@NotNull Long id);
    List<AlunoDTO> findAll();
    List<AlunoDTO> filter(AlunoFilter filter, int page, int size);
 //   long count(Map<String, Object> filters);
    void delete(@NotNull Long id);
    
}

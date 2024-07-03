package com.xavier.service;

import com.xavier.dto.MatriculaDTO;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface MatriculaService {
    
    MatriculaDTO create(@Valid MatriculaDTO matriculaDTO);
    
    MatriculaDTO update(@NotNull Long id, @Valid MatriculaDTO matriculaDTO);
    
    void delete(@NotNull Long id);
    
    List<MatriculaDTO> listAll();
    
    MatriculaDTO findById(@NotNull Long id);
}

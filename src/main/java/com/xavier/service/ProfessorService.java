package com.xavier.service;

import java.util.List;

import com.xavier.dto.ProfessorDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface ProfessorService {
    ProfessorDTO create(@Valid ProfessorDTO professorDTO);
    ProfessorDTO update(@NotNull Long id, @Valid ProfessorDTO professorDTO);
    List<ProfessorDTO> findAll();
    ProfessorDTO findById(@NotNull Long id);
    void delete(@NotNull Long id);
    
}

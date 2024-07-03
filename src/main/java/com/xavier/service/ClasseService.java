package com.xavier.service;

import java.util.List;

import com.xavier.dto.ClasseDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface ClasseService {

    ClasseDTO create(@Valid ClasseDTO classeDTO);
    List<ClasseDTO> listAll();
    ClasseDTO findById(@NotNull Long id);
    ClasseDTO update(@NotNull Long id, @Valid ClasseDTO classeDTO);
    void delete(@NotNull Long id);
    
}

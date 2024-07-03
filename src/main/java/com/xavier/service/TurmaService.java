package com.xavier.service;

import java.util.List;

import com.xavier.dto.TurmaDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface TurmaService {
    TurmaDTO create(@Valid TurmaDTO turmaDTO);
    TurmaDTO update(@NotNull Long id, @Valid TurmaDTO turmaDTO);
    TurmaDTO findById(@NotNull Long id);
    List<TurmaDTO> findAll();
    void delete(@NotNull Long id);
}

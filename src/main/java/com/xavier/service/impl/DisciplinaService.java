package com.xavier.service.impl;

import com.xavier.dto.DisciplinaDTO;

import java.util.List;

public interface DisciplinaService {
    
    DisciplinaDTO create(DisciplinaDTO disciplinaDTO);
    DisciplinaDTO update(Long id, DisciplinaDTO disciplinaDTO);
    List<DisciplinaDTO> findAll();
    DisciplinaDTO findById(Long id);
    void delete(Long id);
}

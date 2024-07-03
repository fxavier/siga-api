package com.xavier.service;

import java.util.List;

import com.xavier.dto.PaiDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface PaiService {

    PaiDTO create(@Valid PaiDTO paiDTO);
    PaiDTO update(@NotNull Long id, @Valid PaiDTO paiDTO);
    PaiDTO findById(@NotNull Long id);
    List<PaiDTO> findAll();
    void delete(@NotNull Long id);
    
}

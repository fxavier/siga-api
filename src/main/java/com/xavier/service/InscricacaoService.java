package com.xavier.service;

import com.xavier.dto.InscricaoDTO;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface InscricacaoService {
    
    InscricaoDTO create(@Valid InscricaoDTO inscricaoDTO);
    InscricaoDTO update(@NotNull Long id,  @Valid InscricaoDTO inscricaoDTO);
    List<InscricaoDTO> findAll();
    InscricaoDTO findById(@NotNull Long id);
    void delete(@NotNull Long id);
}

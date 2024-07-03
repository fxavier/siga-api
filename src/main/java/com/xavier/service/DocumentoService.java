package com.xavier.service;

import java.util.List;

import com.xavier.dto.DocumentoDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface DocumentoService {
    DocumentoDTO create(@Valid DocumentoDTO documentoDTO);
    DocumentoDTO update(@NotNull Long id,  @Valid DocumentoDTO documentotDTO);
    DocumentoDTO findById(@NotNull Long id);
    List<DocumentoDTO> findAll();
    void delete(@NotNull Long id);
}

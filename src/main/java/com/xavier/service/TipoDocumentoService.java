package com.xavier.service;

import com.xavier.dto.TipoDocumentoDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public interface TipoDocumentoService {
    TipoDocumentoDTO create(@Valid TipoDocumentoDTO tipoDocumentoDTO);
    TipoDocumentoDTO update(@NotNull Long id, @Valid TipoDocumentoDTO tipoDocumentoDTO);
    List<TipoDocumentoDTO> findAll();
    TipoDocumentoDTO findById(@NotNull Long id);
    void delete(@NotNull Long id);
}



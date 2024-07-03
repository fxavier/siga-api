package com.xavier.service.impl;

import java.util.List;

import com.xavier.dto.TipoDocumentoDTO;
import com.xavier.model.TipoDocumento;
import com.xavier.repository.TipoDocumentoRepository;
import com.xavier.service.TipoDocumentoService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.Optional;


@ApplicationScoped
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

    @Inject
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Override
    @Transactional
    public TipoDocumentoDTO create(@Valid TipoDocumentoDTO tipoDocumentoDTO) {
        if (existsTipoDocumento(tipoDocumentoDTO.getDescricao())) {
            throw new RuntimeException("Tipo de documento já existe");
            
        }

        TipoDocumento tipoDocumento = toEntity(tipoDocumentoDTO);
        tipoDocumentoRepository.persist(tipoDocumento);
        return toDTO(tipoDocumento);
    }

    @Override
    @Transactional
    public TipoDocumentoDTO update(@NotNull Long id, @Valid TipoDocumentoDTO tipoDocumentoDTO) {
        Optional<TipoDocumento> tipoDocumentoOptional = tipoDocumentoRepository.findByIdOptional(id);
        if (!tipoDocumentoOptional.isPresent()) {
            throw new RuntimeException("Tipo de documento não encontrado");
        }
        TipoDocumento tipoDocumento = tipoDocumentoOptional.get();
        tipoDocumento.setDescricao(tipoDocumentoDTO.getDescricao());
        tipoDocumentoRepository.persist(tipoDocumento);
        return toDTO(tipoDocumento);

    }

    @Override
    public List<TipoDocumentoDTO> findAll() {
        return tipoDocumentoRepository.listAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public TipoDocumentoDTO findById(@NotNull Long id) {
        Optional<TipoDocumento> tipoDocumentoOptional = tipoDocumentoRepository.findByIdOptional(id);
        if (!tipoDocumentoOptional.isPresent()) {
            throw new RuntimeException("Tipo de documento não encontrado");
        }
        return toDTO(tipoDocumentoOptional.get());
    }

    @Override
    @Transactional
    public void delete(@NotNull Long id) {
        Optional<TipoDocumento> tipoDocumentoOptional = tipoDocumentoRepository.findByIdOptional(id);
        if (!tipoDocumentoOptional.isPresent()) {
            throw new RuntimeException("Tipo de documento não encontrado");
        }
        tipoDocumentoRepository.delete(tipoDocumentoOptional.get());
    }

    private TipoDocumentoDTO toDTO(TipoDocumento tipoDocumento) {
        return TipoDocumentoDTO.builder()
                .id(tipoDocumento.getId())
                .descricao(tipoDocumento.getDescricao())
                .build();
    }

    private TipoDocumento toEntity(TipoDocumentoDTO tipoDocumentoDTO) {
        return TipoDocumento.builder()
                .id(tipoDocumentoDTO.getId())
                .descricao(tipoDocumentoDTO.getDescricao())
                .build();
    }

    private boolean existsTipoDocumento(String descricao) {
        return tipoDocumentoRepository.findByDescricao(descricao) != null;
    }
    
}

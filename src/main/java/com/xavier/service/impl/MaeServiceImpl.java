package com.xavier.service.impl;

import java.util.List;
import java.util.Optional;

import com.xavier.model.Mae;
import com.xavier.dto.MaeDTO;
import com.xavier.exception.ServiceException;
import com.xavier.repository.MaeRepository;
import com.xavier.service.MaeService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.NonNull;


@ApplicationScoped
public class MaeServiceImpl implements MaeService {

   @Inject
    private MaeRepository maeRepository;

    @Override
    @Transactional
    public MaeDTO create(@Valid MaeDTO maeDTO) {
        Mae mae = toEntity(maeDTO);
        maeRepository.persist(mae);
        return toDTO(mae);
    }

    @Override
    @Transactional
    public MaeDTO update(@NonNull Long id, @Valid MaeDTO maeDTO) {
        Optional<Mae> maeOptional = maeRepository.findByIdOptional(id);
        if (!maeOptional.isPresent()) {
            throw new ServiceException("Mae com id[%s] nao encontrado", id);
        }
        Mae mae = maeRepository.findByIdOptional(id).get();
        mae.setNome(maeDTO.getNome());
        mae.setEmail(maeDTO.getEmail());
        mae.setTelefone(maeDTO.getTelefone());
        mae.setEndereco(maeDTO.getEndereco());
        return toDTO(mae);
    }

    @Override
    public List<MaeDTO> findAll() {
       return maeRepository.listAll()
              .stream()
              .map(this::toDTO)
              .toList();
    }

    @Override
    public MaeDTO findById(@NonNull Long id) {
        Mae mae = maeRepository.findByIdOptional(id)
                .orElseThrow(() -> new ServiceException("Mae nao encontrado com id[%s]", id));
        return toDTO(mae);
    }

    @Override
    public void delete(@NonNull Long id) {
        Mae mae = maeRepository.findByIdOptional(id)
                .orElseThrow(() -> new ServiceException("Mae nao encontrado com id[%s]", id));
        maeRepository.delete(mae);
    }

    public MaeDTO toDTO(Mae mae) {
        return MaeDTO
                .builder()
                .id(mae.getId())
                .nome(mae.getNome())
                .telefone(mae.getTelefone())
                .email(mae.getEmail())
                .endereco(mae.getEndereco())
                .build();
    }
    
    public Mae toEntity(MaeDTO maeDTO) {
        return Mae
                .builder()
                .id(maeDTO.getId())
                .nome(maeDTO.getNome())
                .telefone(maeDTO.getTelefone())
                .email(maeDTO.getEmail())
                .endereco(maeDTO.getEndereco())
                .build();
    }

}

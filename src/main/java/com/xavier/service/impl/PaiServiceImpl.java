package com.xavier.service.impl;

import java.util.List;
import java.util.Optional;

import com.xavier.dto.PaiDTO;
import com.xavier.exception.ServiceException;
import com.xavier.model.Pai;
import com.xavier.repository.PaiRepository;
import com.xavier.service.PaiService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@ApplicationScoped
public class PaiServiceImpl implements PaiService {

    @Inject
    private PaiRepository paiRepository;

    @Override
    @Transactional
    public PaiDTO create(@Valid PaiDTO paiDTO) {
        Pai pai = toEntity(paiDTO);
        paiRepository.persist(pai);
        return toDTO(pai);
    }

    @Override
    @Transactional
    public PaiDTO update(@NotNull Long id, @Valid PaiDTO paiDTO) {
        Optional<Pai> paiOptional = paiRepository.findByIdOptional(id);
        if (!paiOptional.isPresent()) {
            throw new ServiceException("Pai com id[%s] nao encontrado", id);
        }
        Pai pai = paiOptional.get();
        pai.setNome(paiDTO.getNome());
        pai.setEmail(paiDTO.getEmail());
        pai.setTelefone(paiDTO.getTelefone());
        pai.setEndereco(paiDTO.getEndereco());
        return toDTO(pai);
        
    }

    @Override
    public PaiDTO findById(@NotNull Long id) {
        Pai pai = paiRepository.findByIdOptional(id)
                .orElseThrow(() -> new ServiceException("Pai nao encontrado com id[%s]", id));
        return toDTO(pai);
    }

    @Override
    public List<PaiDTO> findAll() {
        return paiRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public void delete(@NotNull Long id) {
        Optional<Pai> paiOptional = paiRepository.findByIdOptional(id);
        if (!paiOptional.isPresent()) {
            throw new ServiceException("Pai com id[%s] nao encontrado", id);
        }
        paiRepository.delete(paiOptional.get());
    }

    private PaiDTO toDTO(Pai pai) {
        return PaiDTO.builder()
                .id(pai.getId())
                .nome(pai.getNome())
                .email(pai.getEmail())
                .telefone(pai.getTelefone())
                .endereco(pai.getEndereco())
                .build();
    }

    private Pai toEntity(PaiDTO paiDTO) {
        return Pai.builder()
                .id(paiDTO.getId())
                .nome(paiDTO.getNome())
                .email(paiDTO.getEmail())
                .telefone(paiDTO.getTelefone())
                .endereco(paiDTO.getEndereco())
                .build();
    }

    
}

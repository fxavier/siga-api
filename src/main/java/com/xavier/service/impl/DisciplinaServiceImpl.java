package com.xavier.service.impl;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.xavier.dto.DisciplinaDTO;
import com.xavier.exception.ServiceException;
import com.xavier.model.Classe;
import com.xavier.model.Disciplina;
import com.xavier.repository.DisciplinaRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class DisciplinaServiceImpl implements DisciplinaService {

    @Inject
    private DisciplinaRepository disciplinaRepository;

    @Override
    @Transactional
    public DisciplinaDTO create(DisciplinaDTO disciplinaDTO) {
        Disciplina disciplina = toEntity(disciplinaDTO);
        disciplinaRepository.persist(disciplina);
        return toDTO(disciplina);
    }

    @Override
    @Transactional
    public DisciplinaDTO update(Long id, DisciplinaDTO disciplinaDTO) {
        Disciplina disciplina = disciplinaRepository.findByIdOptional(id)
                .orElseThrow(() -> new ServiceException("Disciplina not found"));
        try {
            BeanUtils.copyProperties(disciplina, disciplinaDTO);
        } catch (Exception e) {
            throw new ServiceException("Error converting DisciplinaDTO to Disciplina", e);
        }
        disciplinaRepository.persist(disciplina);
        return toDTO(disciplina);
    }

    @Override
    public List<DisciplinaDTO> findAll() {
        return disciplinaRepository
                .findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public DisciplinaDTO findById(Long id) {
        return disciplinaRepository
                .findByIdOptional(id)
                .map(this::toDTO)
                .orElseThrow(() -> new ServiceException("Disciplina not found"));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Disciplina disciplina = disciplinaRepository.findByIdOptional(id)
               .orElseThrow(() -> new ServiceException("Disciplina not found"));
        disciplinaRepository.delete(disciplina);
    }

    private DisciplinaDTO toDTO(Disciplina disciplina) {
        return DisciplinaDTO.builder()
                            .id(disciplina.getId())
                            .codigo(disciplina.getCodigo())
                            .designacao(disciplina.getDesignacao())
                            .classeId(disciplina.getClasse().getId())
                            .build();
    }

    private Disciplina toEntity(DisciplinaDTO disciplinaDTO) {
        return Disciplina.builder()
                         .codigo(disciplinaDTO.getCodigo())
                         .designacao(disciplinaDTO.getDesignacao())
                         .classe(Classe.builder().id(disciplinaDTO.getClasseId()).build())
                         .build();
    }

    
}

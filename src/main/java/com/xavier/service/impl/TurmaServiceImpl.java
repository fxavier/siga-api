package com.xavier.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;

import com.xavier.dto.TurmaDTO;

import com.xavier.exception.ServiceException;

import com.xavier.model.Classe;
import com.xavier.model.Turma;

import com.xavier.repository.ClasseRepository;
import com.xavier.repository.TurmaRepository;

import com.xavier.service.TurmaService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@ApplicationScoped
public class TurmaServiceImpl implements TurmaService {

    @Inject
    TurmaRepository turmaRepository;

    @Inject
    ClasseRepository classeRepository;


    @Override
    @Transactional
    public TurmaDTO create(@Valid TurmaDTO turmaDTO) {
        Turma turma = toEntity(turmaDTO);
        Optional<Classe> classeOptional = classeRepository.findByIdOptional(turmaDTO.getClasseId());
        if (!classeOptional.isPresent()) {
            throw new ServiceException("Classe not found");
        } 
        turma.setClasse(classeOptional.get());
        turmaRepository.persist(turma);
        return toDTO(turma);
    }

    @Override
    @Transactional
    public TurmaDTO update(@NotNull Long id, @Valid TurmaDTO turmaDTO) {
        Turma turma = turmaRepository.findById(id);
        if (turma == null) {
            throw new ServiceException("Turma not found");
        }
        try {
            BeanUtils.copyProperties(turmaDTO, turma);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new ServiceException("Error copying properties", e);
        }
        Optional<Classe> classeOptional = classeRepository.findByIdOptional(turmaDTO.getClasseId());
        if (!classeOptional.isPresent()) {
            throw new ServiceException("Classe not found");
        }
        turma.setClasse(classeOptional.get());
        turmaRepository.persist(turma);
        return toDTO(turma);
    }

    @Override
    @Transactional
    public TurmaDTO findById(@NotNull Long id) {
        Optional<Turma> turmaOptional = turmaRepository.findByIdOptional(id);
        if (!turmaOptional.isPresent()) {
            throw new ServiceException("Turma not found");
        } 
        return toDTO(turmaOptional.get());
    }

    @Override
    @Transactional
    public List<TurmaDTO> findAll() {
        return turmaRepository.findAll()
                              .stream()
                              .map(this::toDTO)
                              .toList();
    }

    @Override
    @Transactional
    public void delete(@NotNull Long id) {
       Optional<Turma> turmaOptional = turmaRepository.findByIdOptional(id);
         if (!turmaOptional.isPresent()) {
              throw new ServiceException("Turma not found");
         }
        turmaRepository.delete(turmaOptional.get());
    }

     private TurmaDTO toDTO(Turma turma) {
        TurmaDTO turmaDTO = new TurmaDTO();
        try {
            BeanUtils.copyProperties(turmaDTO, turma);
            if (turma.getClasse() != null) {
                turmaDTO.setClasseId(turma.getClasse().getId());
            }
         
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new ServiceException("Error copying properties", e);
        }
        return turmaDTO;
    }

    private Turma toEntity(TurmaDTO turmaDTO) {
        Turma turma = new Turma();
        try {
            BeanUtils.copyProperties(turma, turmaDTO);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new ServiceException("Error copying properties", e);
        }
        return turma;
    }
    
}

package com.xavier.service.impl;

import java.util.List;

import java.util.Optional;

import com.xavier.dto.ClasseDTO;
import com.xavier.exception.ServiceException;
import com.xavier.model.Classe;
import com.xavier.repository.ClasseRepository;
import com.xavier.service.ClasseService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@ApplicationScoped
public class ClasseServiceImpl implements ClasseService {

    @Inject
    private ClasseRepository classeRepository;

    @Override
    @Transactional
    public ClasseDTO create(@Valid ClasseDTO classeDTO) {
        Classe classe = toEntity(classeDTO);

        classeRepository.persist(classe);

        return toDTO(classe);
        
    }

    @Override
    public List<ClasseDTO> listAll() {
        return classeRepository.findAll()
              .stream()
              .map(this::toDTO)
              .toList();
    }

    @Override
    public ClasseDTO findById(@NotNull Long id) {
        Classe classe = classeRepository.findByIdOptional(id)
                      .orElseThrow(() -> new ServiceException("Classe nao encontrado com id[%s]", id));
        return toDTO(classe);
    }

    @Override
    @Transactional
    public ClasseDTO update(@NotNull Long id, @Valid ClasseDTO classeDTO) {
        Optional<Classe> classeOptional = classeRepository.findByIdOptional(id);
        if (!classeOptional.isPresent()) {
            throw new ServiceException("Classe com o id[%s] nao foi encontrado", id);
        }

        Classe classe = classeOptional.get();
        classe.setDesignacao(classeDTO.getDesignacao());
        classe.setSigla(classeDTO.getSigla());
        classe.setDescricao(classeDTO.getDescricao());

        classeRepository.persist(classe);

        return toDTO(classe);
    }

    @Override
    @Transactional
    public void delete(@NotNull Long id) {
        Optional<Classe> classeOptional = classeRepository.findByIdOptional(id);
        if (!classeOptional.isPresent()) {
            throw new ServiceException("Classe com o id[%s] nao foi encontrado", id);
        }
        Classe classe = classeOptional.get();
        classeRepository.delete(classe);
    }

    private ClasseDTO toDTO(Classe classe) {
        return ClasseDTO.builder()
               .id(classe.getId())
               .designacao(classe.getDesignacao())
               .sigla(classe.getSigla())
               .descricao(classe.getSigla())
               .build();
    }

    private Classe toEntity(ClasseDTO classeDTO) {
        return Classe.builder()
               .id(classeDTO.getId())
               .designacao(classeDTO.getDesignacao())
               .sigla(classeDTO.getSigla())
               .descricao(null)
               .build();
    }
    
}

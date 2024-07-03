package com.xavier.service.impl;

import java.util.List;

import com.xavier.dto.ProfessorDTO;
import com.xavier.exception.ServiceException;
import com.xavier.model.Country;
import com.xavier.model.Professor;
import com.xavier.repository.CountryRepository;
import com.xavier.repository.ProfessorRepository;
import com.xavier.service.ProfessorService;

import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@ApplicationScoped
public class ProfessorServiceImpl implements ProfessorService {

    @Inject
    private ProfessorRepository professorRepository;

    @Inject
    private CountryRepository countryRepository;

    @Override
    @Transactional
    public ProfessorDTO create(@Valid ProfessorDTO professorDTO) {
        Professor professor = toEntity(professorDTO);
        Optional<Country> country = countryRepository.findByIdOptional(professorDTO.getNacionalidadeId());
        if (!country.isPresent()) {
            throw new ServiceException("País não encontrado");
        }
        professor.setNacionalidade(country.get());
        professorRepository.persist(professor);
        return toDTO(professor);
    }

    @Override
    @Transactional
    public ProfessorDTO update(@NotNull Long id, @Valid ProfessorDTO professorDTO) {
        Professor professor = professorRepository.findByIdOptional(id)
                .orElseThrow(() -> new ServiceException("Professor não encontrado com id[%s]", id));
        try {
            BeanUtils.copyProperties(professor, professorDTO);
            Optional<Country> country = countryRepository.findByIdOptional(professorDTO.getNacionalidadeId());
            if (country.isPresent()) {
                professor.setNacionalidade(country.get());
            }
        } catch (Exception e) {
            throw new ServiceException("Erro ao converter ProfessorDTO para Professor", e);
        }
        professorRepository.persist(professor);
        return toDTO(professor);
    }

    @Override
    public List<ProfessorDTO> findAll() {
        return professorRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public ProfessorDTO findById(@NotNull Long id) {
       Professor professor = professorRepository.findByIdOptional(id)
               .orElseThrow(() -> new ServiceException("Professor não encontrado com id[%s]", id));
         return toDTO(professor);
    }

    @Override
    @Transactional
    public void delete(@NotNull Long id) {
        Optional<Professor> optionalProfessor = professorRepository.findByIdOptional(id);
        if (!optionalProfessor.isPresent()) {
            throw new ServiceException("Professor não encontrado com id[%s]", id);
        }
        professorRepository.delete(optionalProfessor.get());
    }

    private ProfessorDTO toDTO(Professor professor) {
        ProfessorDTO professorDTO = new ProfessorDTO();
        try {
            BeanUtils.copyProperties(professorDTO, professor);
            if (professor.getNacionalidade() != null) {
                professorDTO.setNacionalidadeId(professor.getNacionalidade().getId());
            }
        } catch (Exception e) {
            throw new ServiceException("Erro ao converter Professor para ProfessorDTO", e);
        }

        return professorDTO;
    }

    private Professor toEntity(ProfessorDTO professorDTO) {
        Professor professor = new Professor();
        try {
            BeanUtils.copyProperties(professor, professorDTO);
        } catch (Exception e) {
            throw new ServiceException("Erro ao converter ProfessorDTO para Professor", e);
        }

        return professor;
    }
    
}

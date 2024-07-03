package com.xavier.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.BeanUtils;

import com.xavier.dto.AlunoDTO;

import com.xavier.exception.ServiceException;

import com.xavier.model.Aluno;
import com.xavier.model.Country;
import com.xavier.model.Mae;
import com.xavier.model.Pai;
import com.xavier.repository.AlunoRepository;
import com.xavier.repository.CountryRepository;
import com.xavier.repository.MaeRepository;
import com.xavier.repository.PaiRepository;
import com.xavier.repository.filter.AlunoFilter;
import com.xavier.service.AlunoService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@ApplicationScoped
public class AlunoServiceImpl implements AlunoService {

    @Inject
    private AlunoRepository alunoRepository;
    
    @Inject
    private PaiRepository paiRepository;

    @Inject
    private MaeRepository maeRepository;

    @Inject
    private CountryRepository  countryRepository;

    @Override
    @Transactional
    public AlunoDTO create(@Valid AlunoDTO alunoDTO) {
        Aluno aluno = toEntity(alunoDTO);
        Optional<Pai> pai = paiRepository.findByIdOptional(alunoDTO.getPaiId());
        Optional<Mae> mae = maeRepository.findByIdOptional(alunoDTO.getMaeId());
        Optional<Country> country = countryRepository.findByIdOptional(alunoDTO.getNacionalidadeId());
        if (pai.isPresent() && mae.isPresent() && country.isPresent()) {
            aluno.setPai(pai.get());
            aluno.setMae(mae.get());
            aluno.setNacionalidade(country.get());
        } else {
            throw new ServiceException("Pai or Mae or Nacionalidade not found");
        }
        alunoRepository.persist(aluno);
        return toDTO(aluno);
    }

    @Override
    @Transactional
    public AlunoDTO update(@NotNull Long id, @Valid AlunoDTO alunoDTO) {
        Aluno aluno = alunoRepository.findByIdOptional(id)
                .orElseThrow(() -> new ServiceException("Aluno with id " + id + " not found"));
        try {
            BeanUtils.copyProperties(aluno, alunoDTO);
            Optional<Pai> pai = paiRepository.findByIdOptional(alunoDTO.getPaiId());
            Optional<Mae> mae = maeRepository.findByIdOptional(alunoDTO.getMaeId());
            Optional<Country> country = countryRepository.findByIdOptional(alunoDTO.getNacionalidadeId());
            if (pai.isPresent() && mae.isPresent() && country.isPresent()) {
                aluno.setPai(pai.get());
                aluno.setMae(mae.get());
                aluno.setNacionalidade(country.get());
            } else {
                throw new ServiceException("Pai, Mae, or Nacionalidade not found");
            }
            alunoRepository.persist(aluno);
        } catch (Exception e) {
            throw new ServiceException("Error updating Aluno", e);
        }
        return toDTO(aluno);
    }

    @Override
    public AlunoDTO findById(@NotNull Long id) {
        Optional<Aluno> alunoOptional = alunoRepository.findByIdOptional(id);
        if (!alunoOptional.isPresent()) {
            throw new ServiceException("Aluno com id " + id + " nao encontrado");   
        }
        return toDTO(alunoOptional.get());
    }

    @Override
    public List<AlunoDTO> findAll() {
        return alunoRepository.findAll()
                              .stream()
                              .map(this::toDTO)
                              .toList();
    }

    @Override
    public List<AlunoDTO> filter(AlunoFilter filter, int page, int size) {
        return alunoRepository.findByFilter(filter, page, size).stream()
                              .map(this::toDTO)
                              .toList();
    }
    
  /*   @Override
    public long count(Map<String, Object> filters) {
        return alunoRepository.count(filters);
    } */

    @Override
    @Transactional
    public void delete(@NotNull Long id) {
        Aluno aluno = alunoRepository.findByIdOptional(id)
                .orElseThrow(() -> new ServiceException("Aluno com " + id + " nao encontrado"));
        alunoRepository.delete(aluno);
    }

    private Aluno toEntity(AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno();
        try {
            BeanUtils.copyProperties(aluno, alunoDTO);
        } catch (Exception e) {
            throw new ServiceException("Error converting AlunoDTO to Aluno", e);
        }
        return aluno;
    }

    private AlunoDTO toDTO(Aluno aluno) {
        AlunoDTO alunoDTO = new AlunoDTO();
        try {
            BeanUtils.copyProperties(alunoDTO, aluno);
            if (aluno.getPai() != null) {
                alunoDTO.setPaiId(aluno.getPai().getId());
            }
            if (aluno.getMae() != null) {
                alunoDTO.setMaeId(aluno.getMae().getId());
            }
            if (aluno.getNacionalidade() != null) {
                alunoDTO.setNacionalidadeId(aluno.getNacionalidade().getId());
            }
        } catch (Exception e) {
            throw new ServiceException("Error converting Aluno to AlunoDTO", e);
        }
        return alunoDTO;
    }
   
    
}

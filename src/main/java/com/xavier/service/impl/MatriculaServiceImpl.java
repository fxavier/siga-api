package com.xavier.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;

import com.xavier.dto.MatriculaDTO;
import com.xavier.exception.ServiceException;
import com.xavier.model.Aluno;
import com.xavier.model.Classe;
import com.xavier.model.Matricula;
import com.xavier.repository.AlunoRepository;
import com.xavier.repository.ClasseRepository;
import com.xavier.repository.MatriculaRepository;
import com.xavier.service.MatriculaService;

import io.vertx.core.cli.Option;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@ApplicationScoped
public class MatriculaServiceImpl implements MatriculaService{

    @Inject
    private MatriculaRepository matriculaRepository;

    @Inject
    private AlunoRepository alunoRepository;

    @Inject
    private ClasseRepository classeRepository;

    @Override
    @Transactional
    public MatriculaDTO create(@Valid MatriculaDTO matriculaDTO) {
        Matricula matricula = toEntity(matriculaDTO);
        Optional<Aluno> aluno = alunoRepository.findByIdOptional(matriculaDTO.getAlunoId());
        if (!aluno.isPresent()) {
            throw new ServiceException("Aluno nao encontrado");
        }
        matricula.setAluno(aluno.get());
        Optional<Classe> classe = classeRepository.findByIdOptional(matriculaDTO.getClasseId());
        if (!classe.isPresent()) {
            throw new ServiceException("Classe nao encontrada");
        }
        matricula.setClasse(classe.get());
        matriculaRepository.persist(matricula);

        return toDTO(matricula);
    }

    @Override
    @Transactional
    public MatriculaDTO update(@NotNull Long id, @Valid MatriculaDTO matriculaDTO) {
        Optional<Matricula> matriculaOptional = matriculaRepository.findByIdOptional(id);
        if (!matriculaOptional.isPresent()) {
            throw new ServiceException("Matricula com o id[%s] nao foi encontrado", id);
        }

        Matricula matricula = matriculaOptional.get();
        try {
            BeanUtils.copyProperties(matricula, matriculaDTO);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new ServiceException("Erro ao copiar propriedades de MatriculaDTO para Matricula", e);
        }

        matriculaRepository.persist(matricula);

        return toDTO(matricula);

    }

    @Override
    @Transactional
    public void delete(@NotNull Long id) {
        Optional<Matricula> matriculaOptional = matriculaRepository.findByIdOptional(id);
        if (!matriculaOptional.isPresent()) {
            throw new ServiceException("Matricula com o id[%s] nao foi encontrado", id);
        }

        matriculaRepository.delete(matriculaOptional.get());
    }

    @Override
    public List<MatriculaDTO> listAll() {
        return matriculaRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public MatriculaDTO findById(@NotNull Long id) {
        Matricula matricula = matriculaRepository.findByIdOptional(id)
                .orElseThrow(() -> new ServiceException("Matricula nao encontrado com id[%s]", id));
        return toDTO(matricula);
    }

    private MatriculaDTO toDTO(Matricula matricula) {
       MatriculaDTO matriculaDTO = new MatriculaDTO();
       try {
           BeanUtils.copyProperties(matriculaDTO, matricula);
              if (matricula.getAluno() != null) {
                matriculaDTO.setAlunoId(matricula.getAluno().getId());
              }
              if (matricula.getClasse() != null) {
                matriculaDTO.setClasseId(matricula.getClasse().getId());
              }
            
       } catch (IllegalAccessException | InvocationTargetException e) {
           throw new ServiceException("Erro ao copiar propriedades de Matricula para MatriculaDTO", e);
       }

         return matriculaDTO;
       
    }

    private Matricula toEntity(MatriculaDTO matriculaDTO) {
        Matricula matricula = new Matricula();
        try {
            BeanUtils.copyProperties(matricula, matriculaDTO);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new ServiceException("Erro ao copiar propriedades de MatriculaDTO para Matricula", e);
        }
        return matricula;
    }
    
}

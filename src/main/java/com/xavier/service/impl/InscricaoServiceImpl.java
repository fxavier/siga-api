package com.xavier.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;

import com.xavier.dto.InscricaoDTO;
import com.xavier.exception.ServiceException;
import com.xavier.model.Aluno;
import com.xavier.model.Inscricao;
import com.xavier.model.Turma;
import com.xavier.repository.AlunoRepository;
import com.xavier.repository.InscricaoRepository;

import com.xavier.repository.TurmaRepository;
import com.xavier.service.InscricacaoService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@ApplicationScoped
public class InscricaoServiceImpl implements InscricacaoService {

    @Inject
    private InscricaoRepository inscricaoRepository;

    @Inject
    private AlunoRepository alunoRepository;

    @Inject
    private TurmaRepository turmaRepository;

    @Override
    @Transactional
    public InscricaoDTO create(@Valid InscricaoDTO inscricaoDTO) {
        Inscricao inscricao = toEntity(inscricaoDTO);
        Optional<Aluno> aluno = alunoRepository.findByIdOptional(inscricaoDTO.getAlunoId());
        Optional<Turma> turma = turmaRepository.findByIdOptional(inscricaoDTO.getTurmaId());
        if (!aluno.isPresent() || !turma.isPresent()) {
            throw new ServiceException("Aluno or Turma not found");
        }
        inscricao.setAluno(aluno.get());
        inscricao.setTurma(turma.get());
        inscricaoRepository.persist(inscricao);
        return toDTO(inscricao);
    }

    @Override
    @Transactional
    public InscricaoDTO update(@NotNull Long id,  @Valid InscricaoDTO inscricaoDTO) {
        Inscricao inscricao = inscricaoRepository.findByIdOptional(id)
                .orElseThrow(() -> new ServiceException("Inscricao não encontrada com id[%s]", id));
        try {
            BeanUtils.copyProperties(inscricao, inscricaoDTO);
            Optional<Aluno> aluno = alunoRepository.findByIdOptional(inscricaoDTO.getAlunoId());
            Optional<Turma> turma = turmaRepository.findByIdOptional(inscricaoDTO.getTurmaId());
            if (aluno.isPresent()) {
                inscricao.setAluno(aluno.get());
            }
            if (turma.isPresent()) {
                inscricao.setTurma(turma.get());
            }
            
        } catch (Exception e) {
            throw new ServiceException("Erro ao converter InscricaoDTO para Inscricao", e);
        }
        inscricaoRepository.persist(inscricao);
        return toDTO(inscricao);
    }

    @Override
    public List<InscricaoDTO> findAll() {
       return inscricaoRepository.findAll()
                                 .stream()
                                 .map(this::toDTO)
                                 .toList();
    }

    @Override
    public InscricaoDTO findById(@NotNull Long id) {
        Optional<Inscricao> inscricaoOptional = inscricaoRepository.findByIdOptional(id);
        if (!inscricaoOptional.isPresent()) {
            throw new ServiceException("Inscricao não encontrada com id[%s]", id);
        }

        return toDTO(inscricaoOptional.get());
    }

    @Override
    @Transactional
    public void delete(@NotNull Long id) {
        Optional<Inscricao> inscricaoOptional = inscricaoRepository.findByIdOptional(id);
        if (!inscricaoOptional.isPresent()) {
            throw new ServiceException("Inscricao não encontrada com id[%s]", id);
        }

        inscricaoRepository.delete(inscricaoOptional.get());
    }

    private InscricaoDTO toDTO(Inscricao inscricao) {
        InscricaoDTO inscricaoDTO = new InscricaoDTO();
        try {
            BeanUtils.copyProperties(inscricaoDTO, inscricao);
            if (inscricao.getAluno() != null) {
                inscricaoDTO.setAlunoId(inscricao.getAluno().getId());
            }
            if (inscricao.getTurma() != null) {
                inscricaoDTO.setTurmaId(inscricao.getTurma().getId());
            }
           
        } catch (Exception e) {
            throw new ServiceException("Error converting Inscricao to InscricaoDTO", e);
        }
        return inscricaoDTO;
    }

    private Inscricao toEntity(InscricaoDTO inscricaoDTO) {
        Inscricao inscricao = new Inscricao();
        try {
            BeanUtils.copyProperties(inscricao, inscricaoDTO);
        } catch (Exception e) {
            throw new ServiceException("Error converting InscricaoDTO to Inscricao", e);
        }
        return inscricao;
    }
    
}

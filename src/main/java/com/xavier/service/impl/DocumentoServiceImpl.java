package com.xavier.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;

import com.xavier.dto.AlunoDTO;
import com.xavier.dto.DocumentoDTO;
import com.xavier.dto.TipoDocumentoDTO;
import com.xavier.exception.ServiceException;
import com.xavier.model.Aluno;
import com.xavier.model.Classe;
import com.xavier.model.Documento;
import com.xavier.model.TipoDocumento;
import com.xavier.repository.AlunoRepository;
import com.xavier.repository.DocumentoRepository;
import com.xavier.repository.TipoDocumentoRepository;
import com.xavier.service.DocumentoService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.spi.Bean;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@ApplicationScoped
public class DocumentoServiceImpl implements DocumentoService {

    @Inject
    DocumentoRepository documentoRepository;

    @Inject
    TipoDocumentoRepository tipoDocumentoRepository;

    @Inject
    AlunoRepository alunoRepository;

    @Override
    @Transactional
    public DocumentoDTO create(@Valid DocumentoDTO documentoDTO) {
        Documento documento = toEntity(documentoDTO);

        Optional<TipoDocumento> tipoDocumentoOptional = tipoDocumentoRepository.findByIdOptional(documentoDTO.getTipoDocumentoId());
        if (!tipoDocumentoOptional.isPresent()) {
            throw new ServiceException("Tipo de documento nao encontrado");
        }
        documento.setTipoDocumento(tipoDocumentoOptional.get());

        Optional<Aluno> alunoOptional = alunoRepository.findByIdOptional(documentoDTO.getAlunoId());
        if (!alunoOptional.isPresent()) {
            throw new ServiceException("Aluno nao encontrado");
        }
        documento.setAluno(alunoOptional.get());

        documentoRepository.persist(documento);
        return toDTO(documento);

    }

    @Override
    @Transactional
    public DocumentoDTO update(@NotNull Long id, @Valid DocumentoDTO documentotDTO) {
        Optional<Documento> documentoOptional = documentoRepository.findByIdOptional(id);
        if (!documentoOptional.isPresent()) {
            throw new ServiceException("Documento nao encontrado");
        }
        Documento documento = documentoOptional.get();
        try {
            BeanUtils.copyProperties(documento, documentotDTO);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new ServiceException("Erro ao copiar propriedades", e);
        }
        documentoRepository.persist(documento);
        return toDTO(documento);
    }

    @Override
    public DocumentoDTO findById(@NotNull Long id) {
        Optional<Documento> documentoOptional = documentoRepository.findByIdOptional(id);
        if (!documentoOptional.isPresent()) {
            throw new ServiceException("Documento nao encontrado");
        }
        return toDTO(documentoOptional.get());
    }

    @Override
    public List<DocumentoDTO> findAll() {
        return documentoRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    @Transactional
    public void delete(@NotNull Long id) {
        Optional<Documento> documentoOptional = documentoRepository.findByIdOptional(id);
        if (!documentoOptional.isPresent()) {
            throw new ServiceException("Documento nao encontrado");
        }
        documentoRepository.delete(documentoOptional.get());
    }

    private DocumentoDTO toDTO(Documento documento) {
        DocumentoDTO documentoDTO = new DocumentoDTO();
        try {
            BeanUtils.copyProperties(documentoDTO, documento);
            if (documento.getTipoDocumento() != null) {
                documentoDTO.setTipoDocumentoId(documento.getTipoDocumento().getId());
            }
            if (documento.getAluno() != null) {
                documentoDTO.setAlunoId(documento.getAluno().getId());
            }
        } catch (Exception e) {
            throw new ServiceException("Erro ao copiar propriedades", e);
        }

        return documentoDTO;
    }

    private Documento toEntity(DocumentoDTO documentoDTO) {
        Documento documento = new Documento();
        try {
            BeanUtils.copyProperties(documento, documentoDTO);
        } catch (Exception e) {
            throw new ServiceException("Erro ao copiar propriedades", e);
        }
        return documento;
    }

   
    
}

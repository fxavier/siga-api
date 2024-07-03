package com.xavier.service;

import java.util.List;

import com.xavier.dto.MaeDTO;

import jakarta.validation.Valid;
import lombok.NonNull;



public interface MaeService {
    MaeDTO create(@Valid MaeDTO maeDTO);
    MaeDTO update(@NonNull Long id, @Valid MaeDTO maeDTO);
    List<MaeDTO> findAll();
    MaeDTO findById(@NonNull Long id);
    void delete(Long id);

    
}

package com.xavier.dto;

import com.xavier.model.Classe;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DisciplinaDTO {
    
    private Integer id;
    private String codigo;
    private String designacao;
    @NotNull(message = "{Object.obj.required}")
    private Integer classeId;
    
}

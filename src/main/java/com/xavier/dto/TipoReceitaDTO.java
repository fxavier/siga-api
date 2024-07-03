package com.xavier.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoReceitaDTO {
    private Long id;
    private String descricao;
    private String observacao;
    private boolean activo;
}

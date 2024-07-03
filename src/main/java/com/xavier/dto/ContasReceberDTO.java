package com.xavier.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

import com.xavier.model.Aluno;
import com.xavier.model.CategoriaConta;
import com.xavier.model.TipoReceita;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContasReceberDTO {
    private Long id;
    private Aluno aluno;
    private CategoriaConta categoriaConta;
    private TipoReceita tipoReceita;
    private BigDecimal valor;
    private String descricao;
    private String numeroRecibo;
}

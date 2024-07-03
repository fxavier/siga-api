package com.xavier.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

import com.xavier.model.CategoriaConta;
import com.xavier.model.Fornecedor;
import com.xavier.model.TipoDespesa;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContasPagarDTO {
    private Long id;
    private Fornecedor fornecedor;
    private CategoriaConta categoriaConta;
    private TipoDespesa tipoDespesa;
    private BigDecimal valor;
    private String descricao;
}

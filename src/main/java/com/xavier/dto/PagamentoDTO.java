package com.xavier.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.xavier.model.Aluno;
import com.xavier.model.FormaPagamento;
import com.xavier.model.TipoPagamento;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoDTO {
    private Long id;
    private Aluno aluno;
    private BigDecimal valor;
    private LocalDate dataPagamento;
    private TipoPagamento tipoPagamento;
    private FormaPagamento formaPagamento;
}

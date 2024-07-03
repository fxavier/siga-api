package com.xavier.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contas_pagar")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContasPagar extends TransacaoFinanceira {

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;
    @ManyToOne
    @JoinColumn(name = "categoria_conta_id")
    private CategoriaConta categoriaConta;
    @ManyToOne
    @JoinColumn(name = "tipo_despesa_id")
    private TipoDespesa tipoDespesa;
}

package com.xavier.model;

import jakarta.persistence.Column;
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
@Table(name = "contas_receber")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContasReceber extends TransacaoFinanceira {
  
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;
    @ManyToOne
    @JoinColumn(name = "categoria_conta_id")
    private CategoriaConta categoriaConta;
    @ManyToOne
    @JoinColumn(name = "tipo_receita_id")
    private TipoReceita tipoReceita;
    @Column(name = "numero_recibo")
    private String numeroRecibo;
    
}

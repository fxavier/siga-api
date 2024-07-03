package com.xavier.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FormaPagamento {
    DINHEIRO("Dinheiro"),
    CARTAO_CREDITO("Cartão de Crédito"),
    CARTAO_DEBITO("Cartão de Débito"),
    CHEQUE("Cheque"),
    TRANSFERENCIA_BANCARIA("Transferência Bancária"),
    POS("POS");

    private String descricao;
}

package com.xavier.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoPagamento {
    PROPINAS("Propinas"),
    MATRICULA("Matrícula"),
    INSCRICAO("Inscrição"),
    TRANSPORTE("Transporte"),
    ALIMENTACAO("Alimentação"),
    ESTUDO_ORIENTADO("Estudo Orientado");

    private String descricao;
}

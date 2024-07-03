package com.xavier.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusInscricao {
    INSCRITA("Inscrito"),
    PENDENTE("Cancelado"),
    CANCELADA("Não Inscrito");

    private String descricao;
}

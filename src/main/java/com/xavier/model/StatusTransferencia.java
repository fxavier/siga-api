package com.xavier.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusTransferencia {
    PENDENTE("Pendente"),
    CONCLUIDA("Concluída"),
    CANCELADA("Cancelada");

    private String descricao;
}

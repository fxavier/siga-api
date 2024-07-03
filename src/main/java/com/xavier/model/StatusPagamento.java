package com.xavier.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusPagamento {
    PENDENTE("Pendente"),
    PAGO("Pago"),
    ATRASADO("Atrasado"),
    CANCELADO("Cancelado");

    private String descricao;
}

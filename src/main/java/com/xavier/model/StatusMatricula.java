package com.xavier.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusMatricula {
    ACTIVA("Activa"),
    TRANCADA("Trancada"),
    CANCELADA("Cancelada"),
    CONCLUIDA("Concluída");

    private String descricao;
}

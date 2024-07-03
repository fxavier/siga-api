package com.xavier.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Turno {
    MANHA("Manhã"),
    TARDE("Tarde"),
    POSLABORAL("Pós-laboral");

    private String descricao;
}

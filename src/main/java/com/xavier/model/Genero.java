package com.xavier.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Genero {
    
    MASCULINO("Masculino"),
    FEMININO("Feminino");

    private String descricao;

}

package com.xavier.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClasseDTO {
    private Integer id;
    @NotEmpty(message = "{Object.required}")
    private String designacao;
    @NotEmpty(message = "{Object.required}")
    private String sigla;
    private String descricao;
}

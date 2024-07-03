package com.xavier.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FornecedorDTO {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
}

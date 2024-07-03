package com.xavier.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaiDTO {
    private Long id;
    @NotEmpty(message = "{Object.required}")
    private String nome;
    @NotEmpty(message = "{Object.required}")
    private String telefone;
    @Email(message = "{Object.email.invalid}")
    private String email;
    @NotEmpty(message = "{Object.required}")
    private String endereco;
}

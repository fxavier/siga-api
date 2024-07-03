package com.xavier.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MaeDTO {

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

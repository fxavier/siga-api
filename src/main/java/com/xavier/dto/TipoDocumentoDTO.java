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
public class TipoDocumentoDTO {
    private Long id;
    @NotEmpty(message = "{Object.required}")
    private String descricao;
}

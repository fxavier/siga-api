package com.xavier.dto;

import com.xavier.model.Aluno;
import com.xavier.model.Documento;
import com.xavier.model.TipoDocumento;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Jacksonized
public class DocumentoDTO {

    private Long id;
    @NotNull(message = "{Object.obj.required}")
    private Long alunoId;
    @NotNull(message = "{Object.obj.required}")
    private Long tipoDocumentoId;
    @NotNull(message = "{Object.data.required}")
    private LocalDate dataEmissao;
    private String arquivoDigital;
    
}

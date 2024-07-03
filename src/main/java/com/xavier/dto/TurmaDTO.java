package com.xavier.dto;

import com.xavier.model.Turno;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TurmaDTO {
    private Integer id;
    private String codigo;
    private String designacao;
    @NotEmpty(message = "{Object.required}")
    private String anoLectivo;
    @NotNull(message = "{Object.obj.required}")
    private Turno turno;
    @NotEmpty(message = "{Object.required}")
    private String sala;
    @NotNull(message = "{Object.obj.required}")
    private Integer classeId;
    // private List<Long> alunoIds;
    // private List<Long> professorIds;
}

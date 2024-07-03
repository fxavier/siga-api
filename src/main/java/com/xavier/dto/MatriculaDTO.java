package com.xavier.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

import com.xavier.model.StatusMatricula;

import jakarta.validation.constraints.NotNull;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaDTO {
    private Long id;
    @NotNull(message = "{Object.obj.required}")
    private Integer anoLectivo;
    @NotNull(message = "{Object.obj.required}")
    private Long alunoId;
    @NotNull(message = "{Object.obj.required}")
    private Integer classeId;
    @NotNull(message = "{Object.data.required}")
    private LocalDate dataMatricula;
    @NotNull(message = "{Object.obj.required}")
    private StatusMatricula statusMatricula;
}

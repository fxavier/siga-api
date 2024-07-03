package com.xavier.dto;

import com.xavier.model.Aluno;
import com.xavier.model.StatusInscricao;
import com.xavier.model.Turma;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InscricaoDTO {
    private Long id;
    @NotNull(message = "{Object.obj.required}")
    private Integer anoLectivo;
    @NotNull(message = "{Object.data.required}")
    private LocalDate dataInscricao;
    @NotNull(message = "{Object.obj.required}")
    private Long alunoId;
    @NotNull(message = "{Object.obj.required}") 
    private Integer turmaId;
    @NotNull(message = "{Object.obj.required}")
    private StatusInscricao statusInscricao;
}

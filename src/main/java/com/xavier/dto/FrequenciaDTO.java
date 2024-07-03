package com.xavier.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

import com.xavier.model.Aluno;
import com.xavier.model.Disciplina;
import com.xavier.model.Professor;
import com.xavier.model.Turma;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FrequenciaDTO {
    private Long id;
    private Integer anoLectivo;
    private Integer numeroFaltas;
    private Aluno aluno;
    private Turma turma;
    private Professor professor;
    private Disciplina disciplina;
    private BigDecimal nota;
}

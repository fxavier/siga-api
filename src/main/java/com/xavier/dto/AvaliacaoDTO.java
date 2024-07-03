package com.xavier.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

import com.xavier.model.Aluno;
import com.xavier.model.Classe;
import com.xavier.model.Disciplina;
import com.xavier.model.Professor;
import com.xavier.model.TipoAvaliacao;
import com.xavier.model.Turma;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoDTO {
    private Long id;
    private Disciplina disciplina;
    private Aluno aluno;
    private Professor professor;
    private Turma turma;
    private Classe classe;
    private Integer anoLectivo;
    private BigDecimal nota;
    private TipoAvaliacao tipoAvaliacao;
    private String observacao;
}

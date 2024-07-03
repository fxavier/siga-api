package com.xavier.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "frequencia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Frequencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(name = "ano_lectivo")
    private Integer anoLectivo;
    @Column(name = "numero_faltas")
    private Integer numeroFaltas;
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;
    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turma turma;
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;
    private BigDecimal nota;
}

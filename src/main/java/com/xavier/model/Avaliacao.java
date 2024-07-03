package com.xavier.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "avaliacao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turma turma;
    @ManyToOne
    @JoinColumn(name = "classe_id")
    private Classe classe;
    @Column(name = "ano_lectivo")
    private Integer anoLectivo;
    private BigDecimal nota;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_avaliacao")
    private TipoAvaliacao tipoAvaliacao;
    private String observacao;
}

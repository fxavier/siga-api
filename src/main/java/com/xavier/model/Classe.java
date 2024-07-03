package com.xavier.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "classe")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    private String designacao;
    private String sigla;
    private String descricao;

    @OneToMany(mappedBy = "classe")
    List<Disciplina> disciplinas;
    @OneToMany(mappedBy = "classe")
    List<Turma> turmas;
    
}

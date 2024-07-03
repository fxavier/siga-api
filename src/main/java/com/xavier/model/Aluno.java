package com.xavier.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "aluno")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String numero;
    @Column(name = "primeiro_nome")
    private String primeiroNome;
    @Column(name = "segundo_nome")
    private String segundoNome;
    @Column(name = "apelido")
    private String apelido;
    @Enumerated(EnumType.STRING)
    private Genero genero;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    @ManyToOne
    @JoinColumn(name = "nacionalidade_id")
  //  @JsonIgnore
    private Country nacionalidade;
    private String telefone;
    private String email;
    private String endereco;
    private String foto;
    @ManyToOne
    @JoinColumn(name = "pai_id")
   // @JsonIgnore
    private Pai pai;
    @ManyToOne
    @JoinColumn(name = "mae_id")
   // @JsonIgnore
    private Mae mae;
    // @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
    // private List<Documento> documentos;



 
    
}

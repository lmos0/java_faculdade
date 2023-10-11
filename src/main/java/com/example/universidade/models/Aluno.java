package com.example.universidade.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "aluno")
@Table(name = "alunos")
@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matricula;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "nascimento")
    private LocalDate nascimento;

    @OneToOne(mappedBy = "aluno", cascade = CascadeType.REMOVE)
    private Endereco endereco;

    @Column(unique = true, name = "email")
    private String email;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.REMOVE)
    private List<Inscricao> inscricao;

//    @PrePersist
//    public Void geraMatricula() {
//        /* "1"+ano+semeste+"1"+curso+num_aluno_na_turma */
//
//    }
}

package com.example.universidade.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "turma")
@Table(name = "turmas")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "horario", nullable = false)
    private String horario;

    @Column(name = "sala", nullable = false)
    private String sala;

    @Column(name = "semestre", nullable = false)
    private Integer semestre;

    @Column(name = "total_aulas", nullable = false)
    private Integer totalAulas;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_disciplina", nullable = false)
    private Disciplina disciplina;

    @OneToMany(mappedBy = "turma", cascade = CascadeType.REMOVE)
    private List<Inscricao> inscricao;
}

package com.example.universidade.models;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "dados_endereco")
@Table(name = "dados_endereco")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rua")
    private String rua;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "cep")
    private String cep;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;
}

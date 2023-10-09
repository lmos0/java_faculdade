package com.example.universidade.models;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "departamento")
@Table(name = "departamentos")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

}

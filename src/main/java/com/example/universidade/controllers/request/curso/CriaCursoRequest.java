package com.example.universidade.controllers.request.curso;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class CriaCursoRequest implements Serializable {

    private String nome;
    private Integer quantidadeAnos;
    private Long idDepartamento;
}

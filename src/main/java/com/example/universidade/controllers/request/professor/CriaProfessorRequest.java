package com.example.universidade.controllers.request.professor;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class CriaProfessorRequest implements Serializable {

    private String nome;
    private String sobrenome;
    private Long idDepartamento;
}

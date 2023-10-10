package com.example.universidade.controllers.request.disciplina;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class CriaDisciplinaRequest implements Serializable {
    private String nome;
    private String cargaHoraria;
    private Long idCurso;
    private Long idProfessor;
}

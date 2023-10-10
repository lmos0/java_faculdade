package com.example.universidade.controllers.response.disciplina;

import com.example.universidade.models.Curso;
import com.example.universidade.models.Disciplina;
import com.example.universidade.models.Professor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class DisciplinaBuscaPorIdResponse implements Serializable {

    private String nome;
    private String cargaHoraria;
    private String curso;
    private String professor;
    private Long id;

    public static DisciplinaBuscaPorIdResponse buscaPorIdResponse(Disciplina model) {

        return DisciplinaBuscaPorIdResponse.builder()
                .nome(model.getNome())
                .cargaHoraria(model.getCargaHoraria())
                .curso(model.getCurso().getNome())
                .professor(model.getProfessor().getNome())
                .id(model.getId())
                .build();
    }
}

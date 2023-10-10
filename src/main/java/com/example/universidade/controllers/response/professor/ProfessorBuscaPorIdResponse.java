package com.example.universidade.controllers.response.professor;

import com.example.universidade.models.Professor;
import com.example.universidade.models.enums.TitulacaoProfessor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class ProfessorBuscaPorIdResponse implements Serializable {

    private String nome;
    private String sobrenome;
    private String departamento;
    private TitulacaoProfessor titulacao;
    private Long id;

    public static ProfessorBuscaPorIdResponse professorBuscaPorIdResonse(Professor model) {
        return ProfessorBuscaPorIdResponse.builder()
                .nome(model.getNome())
                .sobrenome(model.getSobrenome())
                .departamento(model.getDepartamento().getNome())
                .titulacao(model.getTitulacao())
                .id(model.getId())
                .build();
    }
}

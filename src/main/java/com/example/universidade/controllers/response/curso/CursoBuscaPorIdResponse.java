package com.example.universidade.controllers.response.curso;

import com.example.universidade.models.Curso;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class CursoBuscaPorIdResponse implements Serializable {

    private String nome;
    private Integer quantidadeAnos;
    private String departamento;
    private Long id;

    public static CursoBuscaPorIdResponse buscaPorIdResponse(Curso model) {

        return CursoBuscaPorIdResponse.builder()
                .nome(model.getNome())
                .quantidadeAnos(model.getQuantidadeAnos())
                .departamento(model.getDepartamento().getNome())
                .id(model.getId())
                .build();
    }
}

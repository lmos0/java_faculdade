package com.example.universidade.controllers.response.departamento;

import com.example.universidade.models.Departamento;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class DepartamentoResponse implements Serializable {

    String nome;
    Long id;

    public static DepartamentoResponse buscaDepartamentos(Departamento departamento) {

        return DepartamentoResponse.builder()
                .nome(departamento.getNome())
                .id(departamento.getId())
                .build();
    }
}

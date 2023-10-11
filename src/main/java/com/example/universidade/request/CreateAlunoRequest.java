package com.example.universidade.request;

import com.example.universidade.dto.EnderecoDto;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CreateAlunoRequest {

    private String nome;

    private LocalDate nascimento;

    private String email;

    private String rua;

    private String bairro;

    private String cidade;

    private String cep;

}

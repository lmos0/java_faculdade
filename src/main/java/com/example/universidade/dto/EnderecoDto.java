package com.example.universidade.dto;

import com.example.universidade.models.Aluno;
import com.example.universidade.models.Endereco;
import jakarta.persistence.*;

public class EnderecoDto {
    private Long id;

    private String rua;

    private String bairro;

    private String cidade;

    private String cep;

    public EnderecoDto (Endereco endereco){
        this.id = endereco.getId();
        this.rua = endereco.getRua();
        this.bairro = endereco.getBairro();
        this.cidade = endereco.getCidade();
        this.cep = endereco.getCep();

    }
}


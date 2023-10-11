package com.example.universidade.dto;

import com.example.universidade.models.Aluno;
import com.example.universidade.models.Endereco;
import jakarta.persistence.*;

import java.time.LocalDate;

public class AlunoDto {

    private Long matricula;

    private String nome;

    private LocalDate nascimento;

    private EnderecoDto endereco;

    private String email;

    public AlunoDto (Aluno aluno){
        this.matricula = aluno.getMatricula();
        this.nome = aluno.getNome();
        this.nascimento = aluno.getNascimento();
        this.endereco = new EnderecoDto(aluno.getEndereco());
        this.email = aluno.getEmail();

    }
}

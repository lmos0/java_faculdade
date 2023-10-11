package com.example.universidade.service;


import com.example.universidade.dto.AlunoDto;
import com.example.universidade.models.Aluno;
import com.example.universidade.models.Endereco;
import com.example.universidade.repositories.AlunoRepository;
import com.example.universidade.repositories.EnderecoRepository;
import com.example.universidade.request.CreateAlunoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {
    private final AlunoRepository alunoRepository;
    private final EnderecoRepository enderecoRepository;

    public List<AlunoDto> getAllAlunos(){
        return alunoRepository.findAll()
                .stream()
                .map(AlunoDto::new)
                .toList();

    }

    public Optional<Aluno> getAlunoById(Long matricula){
        return alunoRepository.findById(matricula);
    }

    public AlunoDto createAluno(CreateAlunoRequest createAlunoRequest){
       var aluno = Aluno.builder()
                .nome(createAlunoRequest.getNome())
                .email(createAlunoRequest.getEmail())
                .nascimento(createAlunoRequest.getNascimento())
                .build();

       var endereco = Endereco.builder()
                .rua(createAlunoRequest.getRua())
                .cep(createAlunoRequest.getCep())
                .bairro(createAlunoRequest.getBairro())
                .cidade(createAlunoRequest.getCidade())
                .build();

        enderecoRepository.save(endereco);
        aluno.setEndereco(endereco);
        endereco.setAluno(aluno);
        alunoRepository.save(aluno);
        return new AlunoDto(aluno);
    }

    public void deleteAluno(Long matricula){
        alunoRepository.deleteById(matricula);
    }
}

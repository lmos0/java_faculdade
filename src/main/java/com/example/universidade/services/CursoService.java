package com.example.universidade.services;

import com.example.universidade.controllers.request.curso.CriaCursoRequest;
import com.example.universidade.controllers.response.curso.CursoBuscaPorIdResponse;
import com.example.universidade.models.Curso;
import com.example.universidade.models.Departamento;
import com.example.universidade.repositories.CursoRepository;
import com.example.universidade.repositories.DepartamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository cursoRepository;
    private final DepartamentoRepository departamentoRepository;

    public Long criaCurso(CriaCursoRequest request) {
        Departamento departamento = departamentoRepository.findById(request.getIdDepartamento())
                .orElseGet(() -> Departamento.builder().nome("Não encontrado").build());

        Curso curso = Curso.builder()
                .nome(request.getNome())
                .quantidadeAnos(request.getQuantidadeAnos())
                .departamento(departamento)
                .build();

        cursoRepository.save(curso);

        return curso.getId();
    }

    public CursoBuscaPorIdResponse buscaPorId(Long id) {
        Curso curso = cursoRepository.findById(id)
                .orElseGet(() -> Curso.builder().nome("Não encontrado").build());
        return CursoBuscaPorIdResponse.buscaPorIdResponse(curso);
    }
}

package com.example.universidade.services;

import com.example.universidade.controllers.request.professor.CriaProfessorRequest;
import com.example.universidade.controllers.response.professor.ProfessorBuscaPorIdResponse;
import com.example.universidade.models.Departamento;
import com.example.universidade.models.Professor;
import com.example.universidade.models.enums.TitulacaoProfessor;
import com.example.universidade.repositories.DepartamentoRepository;
import com.example.universidade.repositories.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final DepartamentoRepository departamentoRepository;

    public Long criaProfessor(CriaProfessorRequest request, TitulacaoProfessor titulacaoProfessor) {

        Departamento departamento = departamentoRepository.findById(request.getIdDepartamento())
                .orElseGet(() -> Departamento.builder().nome("Não encontrado").build());

        Professor professor = Professor.builder()
                .nome(request.getNome())
                .sobrenome(request.getSobrenome())
                .departamento(departamento)
                .titulacao(titulacaoProfessor)
                .build();

        professorRepository.save(professor);

        return professor.getId();
    }

    public ProfessorBuscaPorIdResponse buscaPorId(Long id) {
        Professor professor = professorRepository.findById(id)
                .orElseGet(() -> Professor.builder().nome("Não encontrado").build());

        return ProfessorBuscaPorIdResponse.professorBuscaPorIdResonse(professor);
    }
}

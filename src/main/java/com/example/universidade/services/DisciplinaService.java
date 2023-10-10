package com.example.universidade.services;

import com.example.universidade.controllers.request.disciplina.CriaDisciplinaRequest;
import com.example.universidade.controllers.response.disciplina.DisciplinaBuscaPorIdResponse;
import com.example.universidade.models.Curso;
import com.example.universidade.models.Disciplina;
import com.example.universidade.models.Professor;
import com.example.universidade.repositories.CursoRepository;
import com.example.universidade.repositories.DisciplinaRepository;
import com.example.universidade.repositories.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;
    private final CursoRepository cursoRepository;
    private final ProfessorRepository professorRepository;

    public Long criaDisciplina(CriaDisciplinaRequest request) {
        Curso curso = cursoRepository.findById(request.getIdCurso())
                .orElseGet(() -> Curso.builder().nome("Não encontrado").build());

        Professor professor = professorRepository.findById(request.getIdProfessor())
                .orElseGet(() -> Professor.builder().nome("Não encontrado").build());

        Disciplina disciplina = Disciplina.builder()
                .nome(request.getNome())
                .cargaHoraria(request.getCargaHoraria())
                .curso(curso)
                .professor(professor)
                .build();

        disciplinaRepository.save(disciplina);

        return disciplina.getId();
    }

    public DisciplinaBuscaPorIdResponse buscaPorId(Long id) {
        Disciplina disciplina = disciplinaRepository.findById(id)
                .orElseGet(() -> Disciplina.builder().nome("Não encontrada").build());

        return DisciplinaBuscaPorIdResponse.buscaPorIdResponse(disciplina);
    }
}

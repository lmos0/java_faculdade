package com.example.universidade.service;

import com.example.universidade.models.Turma;
import com.example.universidade.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class TurmaService {
    private final TurmaRepository turmaRepository;

    @Autowired
    public TurmaService(TurmaRepository turmaRepository){
        this.turmaRepository = turmaRepository;
    }

    public List<Turma> getAllTurmas(){
        return turmaRepository.findAll();

    }

    public Optional<Turma> getTurmaById(Long id){
        return turmaRepository.findById(id);
    }

    public Turma createTurma(Turma turma){
        return turmaRepository.save(turma);
    }

    public void deleteTurma(Long id){
        turmaRepository.deleteById(id);
    }

}

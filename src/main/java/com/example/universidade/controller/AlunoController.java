package com.example.universidade.controller;

import com.example.universidade.dto.AlunoDto;
import com.example.universidade.request.CreateAlunoRequest;
import com.example.universidade.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/aluno")
@RequiredArgsConstructor

public class AlunoController {

    private final AlunoService alunoservice;

    @PostMapping
    public ResponseEntity<Void> response(@RequestBody CreateAlunoRequest createAlunoRequest){
        alunoservice.createAluno(createAlunoRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<AlunoDto>> taking(){
        return ResponseEntity.ok()
                .body(alunoservice.getAllAlunos());
    }
}

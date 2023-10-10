package com.example.universidade.controllers;

import com.example.universidade.controllers.request.disciplina.CriaDisciplinaRequest;
import com.example.universidade.controllers.response.disciplina.DisciplinaBuscaPorIdResponse;
import com.example.universidade.services.DisciplinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    @PostMapping("/disciplina")
    public ResponseEntity<Void> criaDisciplina(@RequestBody CriaDisciplinaRequest request) {
        Long id = disciplinaService.criaDisciplina(request);
        return ResponseEntity.created(URI.create("api/v1/disciplina/" + id)).build();
    }

    @GetMapping("/disciplina/{id}")
    public ResponseEntity<DisciplinaBuscaPorIdResponse> buscaPorId(@PathVariable Long id) {
        return new ResponseEntity<>(disciplinaService.buscaPorId(id), HttpStatus.OK);
    }
}

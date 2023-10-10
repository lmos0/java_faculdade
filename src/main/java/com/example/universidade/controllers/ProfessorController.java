package com.example.universidade.controllers;

import com.example.universidade.controllers.request.professor.CriaProfessorRequest;
import com.example.universidade.controllers.response.professor.ProfessorBuscaPorIdResponse;
import com.example.universidade.models.enums.TitulacaoProfessor;
import com.example.universidade.services.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;

    @PostMapping("/professor/{titulacao}")
    public ResponseEntity<Void> criaProfessor(
            @RequestBody CriaProfessorRequest request,
            @PathVariable TitulacaoProfessor titulacao
    ) {
        Long id = professorService.criaProfessor(request, titulacao);
        return ResponseEntity.created(URI.create("api/v1/professores/" + id)).build();
    }

    @GetMapping("/professor/{id}")
    public ResponseEntity<ProfessorBuscaPorIdResponse> buscaPorId(@PathVariable Long id) {
        return new ResponseEntity<>(professorService.buscaPorId(id), HttpStatus.OK);
    }
}

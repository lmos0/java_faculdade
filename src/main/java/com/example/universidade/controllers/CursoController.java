package com.example.universidade.controllers;

import com.example.universidade.controllers.request.curso.CriaCursoRequest;
import com.example.universidade.controllers.response.curso.CursoBuscaPorIdResponse;
import com.example.universidade.services.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class CursoController {

    private final CursoService cursoService;

    @PostMapping("/curso")
    public ResponseEntity<Void> criaCurso(@RequestBody CriaCursoRequest request) {
        Long id = cursoService.criaCurso(request);
        return ResponseEntity.created(URI.create("api/v1/curso/" + id)).build();
    }

    @GetMapping("/curso/{id}")
    public ResponseEntity<CursoBuscaPorIdResponse> buscaPorId(@PathVariable Long id) {
        return new ResponseEntity<>(cursoService.buscaPorId(id), HttpStatus.OK);
    }
}

package com.example.universidade.controllers;

import com.example.universidade.controllers.response.departamento.DepartamentoResponse;
import com.example.universidade.repositories.DepartamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartamentoController {

    private final DepartamentoRepository departamentoRepository;

    @GetMapping("/departamento")
    public ResponseEntity<List<DepartamentoResponse>> buscaDepartamentos() {

        return new ResponseEntity<>(
                departamentoRepository.findAll()
                        .stream()
                        .map(DepartamentoResponse::buscaDepartamentos)
                        .toList(),
                HttpStatus.OK
        );
    }


}

package com.example.universidade;

import com.example.universidade.models.Departamento;
import com.example.universidade.repositories.DepartamentoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
@Log
public class UniversidadeApplication {

    private final DepartamentoRepository departamentoRepository;
    public static void main(String[] args) {

        SpringApplication.run(UniversidadeApplication.class, args);
    }

    @PostConstruct
    public void departamentos() {

        departamentoRepository.save(Departamento.builder()
                .nome("Computação")
                .build());
        log.info("oi");
        departamentoRepository.save(Departamento.builder()
                .nome("Matemática")
                .build());

        departamentoRepository.save(Departamento.builder()
                .nome("Letras")
                .build());
    }
}

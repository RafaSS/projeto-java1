package com.example.demo.controller;

import com.example.demo.exception.BusinessException;
import com.example.demo.modelo.Matricula;
import com.example.demo.servico.MatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/matricula")
@RequiredArgsConstructor
public class MatriculaController {

    private final MatriculaService matriculaService;

    @PostMapping
    public ResponseEntity<Matricula> matricular(

            @RequestBody Matricula matricula) {
        try {
            return ResponseEntity.ok(matriculaService.matricular(matricula));
        } catch (BusinessException e) {
            return ResponseEntity.status(400).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matricula> buscar(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(matriculaService.buscar(id));
        } catch (BusinessException e) {
            return ResponseEntity.status(404).build();
        }
    }
}

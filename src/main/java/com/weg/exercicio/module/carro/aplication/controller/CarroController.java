package com.weg.exercicio.module.carro.aplication.controller;

import com.weg.exercicio.module.carro.aplication.dto.CarroCreateRequestDto;
import com.weg.exercicio.module.carro.aplication.dto.CarroResponseDto;
import com.weg.exercicio.module.carro.aplication.dto.CarroUpdateRequestDto;
import com.weg.exercicio.module.carro.domain.service.CarroService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carro")
@AllArgsConstructor
public class CarroController {

    private final CarroService carroService;

    @PostMapping
    public ResponseEntity<CarroResponseDto> criarCarro(
            @Valid @RequestBody CarroCreateRequestDto novoCarro
    ) {
        try {
            var car = carroService.save(novoCarro);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(car);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<CarroResponseDto>> listarCarros() {
        try {
            var carros = carroService.findAll();
            return ResponseEntity
                    .ok(carros);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarroResponseDto> buscarPorID(
            @PathVariable Long id
    ) {
        try {
            var carroProcurado = carroService.findById(id);

            return ResponseEntity.ok(carroProcurado);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCarro(
            @PathVariable Long id
    ) {
        try {
            carroService.delete(id);

            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarroResponseDto> atualizarDadosCarro(
            @PathVariable Long id,
            @Valid @RequestBody CarroUpdateRequestDto novoDadoCarro
    ) {
        try {
            var carro = carroService.update(id,novoDadoCarro);

            return ResponseEntity.ok(carro);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

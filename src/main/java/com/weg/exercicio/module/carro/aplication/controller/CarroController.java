package com.weg.exercicio.module.carro.aplication.controller;

import com.weg.exercicio.module.carro.aplication.dto.CarroCreateRequestDto;
import com.weg.exercicio.module.carro.aplication.dto.CarroResponseDto;
import com.weg.exercicio.module.carro.aplication.dto.CarroUpdateRequestDto;
import com.weg.exercicio.module.carro.domain.service.CarroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carro")
@AllArgsConstructor
@Tag(name = "Carros", description = "Operações CRUD para gerenciamento de carros")
public class CarroController {

    private final CarroService carroService;

    @PostMapping
    @Operation(
            summary = "Cadastra um novo carro",
            description = "Salva os dados de um novo carro no banco de dados e retorna o registro criado"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Carro criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos na requisição"),
            @ApiResponse(responseCode = "500", description = "Erro no código da API")
    })
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
    @Operation(
            summary = "Lista todos os carros",
            description = "Retorna uma lista com todos os carros cadastrados no banco de dados"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<List<CarroResponseDto>> listarCarros() {
        try {
            var carros = carroService.findAll();
            return ResponseEntity.ok(carros);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Busca carro por ID",
            description = "Retorna os dados de um carro específico a partir do seu ID"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Carro encontrado"),
            @ApiResponse(responseCode = "404", description = "Carro não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<CarroResponseDto> buscarPorID(
            @Parameter(description = "ID do carro a ser buscado", example = "1")
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
    @Operation(
            summary = "Remove um carro",
            description = "Exclui permanentemente um carro do banco de dados pelo seu ID"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Carro excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Carro não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<Void> excluirCarro(
            @Parameter(description = "ID do carro a ser excluído", example = "1")
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
    @Operation(
            summary = "Atualiza dados de um carro",
            description = "Atualiza as informações de um carro existente a partir do seu ID"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Carro atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos na requisição"),
            @ApiResponse(responseCode = "404", description = "Carro não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<CarroResponseDto> atualizarDadosCarro(
            @Parameter(description = "ID do carro a ser atualizado", example = "1")
            @PathVariable Long id,
            @Valid @RequestBody CarroUpdateRequestDto novoDadoCarro
    ) {
        try {
            var carro = carroService.update(id, novoDadoCarro);
            return ResponseEntity.ok(carro);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
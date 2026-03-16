package com.weg.exercicio.module.jogo.aplication.controller;

import com.weg.exercicio.module.jogo.aplication.dto.JogoCreateRequestDto;
import com.weg.exercicio.module.jogo.aplication.dto.JogoResponseDto;
import com.weg.exercicio.module.jogo.domain.service.JogoService;
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
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/jogo")
@Tag(name = "Jogos", description = "Operações CRUD para gerenciamento de Jogos")
public class JogoController {

    private final JogoService jogoService;

    @PostMapping
    @Operation(summary = "Cadastra um novo Jogo",
            description = "Salva os dados de um novo jogo no banco de dados e devolve o registro criado"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Jogo cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos na requisição"),
            @ApiResponse(responseCode = "500", description = "Erro no código da API")
    })
    public ResponseEntity<JogoResponseDto> salvarJogo(
            @Parameter @Valid @RequestBody JogoCreateRequestDto jogoRequest
    ) {
        try {
            var novoJogo = jogoService.save(jogoRequest);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(novoJogo);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping
    @Operation(
            summary = "Lista todos os jogos",
            description = "Lista todos os jogos cadastrados no banco de dados"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Jogos listados com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno na API")
    })
    public ResponseEntity<List<JogoResponseDto>> listarJogos() {
        try {
            var jogos = jogoService.findAll();

            return ResponseEntity.ok(jogos);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Buscar jogo por ID",
            description = "Mostra as informações do jogo buscado por id"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Jogo encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Jogo não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno na API")
    })
    public ResponseEntity<JogoResponseDto> buscarJogoPorId(
            @PathVariable Long id
    ) {
        try {
            var jogo = jogoService.findById(id);

            return ResponseEntity.ok(jogo);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


}

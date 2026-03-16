package com.weg.exercicio.module.jogo.aplication.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

@Schema(description = "Dados de resposta de um jogo")
public record JogoResponseDto(
        @Schema
        Long id,

        @Schema
        String nome,

        @Schema
        String tamanho,

        @Schema
        Double preco,

        @Schema
        String tipoJogo
) {
}

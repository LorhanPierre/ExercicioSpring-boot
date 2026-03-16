package com.weg.exercicio.module.jogo.aplication.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Schema(description = "Dados para a criação de um jogo")
public record JogoCreateRequestDto(

        @Schema
        @NotNull(message = "O nome do jogo não pode ser nulo")
        String nome,

        @Schema
        @NotNull(message = "O tamanho do jogo não pode ser negativo")
        @Positive
        Double tamanhoEmMB,

        @Schema
        @PositiveOrZero
        Double preco,

        @Schema
        @NotNull(message = "O tipo do jogo não pode ser nulo")
        String tipoJogo
) {
}

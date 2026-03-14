package com.weg.exercicio.module.jogo.aplication.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record JogoCreateRequestDto(
        @NotNull(message = "O nome do jogo não pode ser nulo")
        String nome,

        @NotNull(message = "O tamanho do jogo não pode ser negativo")
        @Positive
        Double tamanhoEmMB,

        @PositiveOrZero
        Double preco,

        @NotNull(message = "O tipo do jogo não pode ser nulo")
        String tipoJogo
) {
}

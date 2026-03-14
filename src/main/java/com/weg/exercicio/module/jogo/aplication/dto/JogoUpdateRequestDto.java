package com.weg.exercicio.module.jogo.aplication.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record JogoUpdateRequestDto(

        String nome,

        @Positive
        Double tamanhoEmMB,

        @PositiveOrZero
        Double preco,

        String tipoJogo
) {
}

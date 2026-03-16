package com.weg.exercicio.module.jogo.aplication.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Schema(description = "Dados para a atualização dos dados de um jogo ")
public record JogoUpdateRequestDto(

        @Schema
        String nome,

        @Schema
        @Positive
        Double tamanhoEmMB,

        @Schema
        @PositiveOrZero
        Double preco,

        @Schema
        String tipoJogo
) {
}

package com.weg.exercicio.module.carro.aplication.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;

@Schema(description = "Dados para atualização de um carro")
public record CarroUpdateRequestDto(

        @Schema(description = "Modelo do carro", example = "Civic")
        String modelo,

        @Schema(description = "Ano de fabricação", example = "2025")
        @Min(value = 1885, message = "O ano do carro é inválido")
        Integer anoCarro,

        @Schema(description = "Potência do motor em cavalos", example = "240")
        @Positive
        Double potencia,

        @Schema(description = "Marca do carro", example = "Honda")
        String marca
) {
}
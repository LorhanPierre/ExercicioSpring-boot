package com.weg.exercicio.module.carro.aplication.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Dados retornados de um carro")
public record CarroResponseDto(

        @Schema(description = "ID do carro", example = "1")
        Long id,

        @Schema(description = "Modelo do carro", example = "Civic")
        String modelo,

        @Schema(description = "Ano de fabricação", example = "2025")
        Integer anoCarro,

        @Schema(description = "Potência do motor em cavalos", example = "240")
        Double potencia,

        @Schema(description = "Marca do carro", example = "Honda")
        String marca
) {}
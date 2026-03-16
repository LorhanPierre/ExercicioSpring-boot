package com.weg.exercicio.module.carro.aplication.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

@Schema(description = "Dados para a criação de um carro")
public record CarroCreateRequestDto(

        @Schema(description = "Modelo do carro", example = "Civic")
        @NotBlank(message = "O modelo é obrigatório")
        String modelo,

        @Schema(description = "Ano de fabricação", example = "2025")
        @NotNull(message = "O ano do carro é obrigatório")
        @Min(value = 1885, message = "O ano do carro é inválido")
        Integer anoCarro,

        @Schema(description = "Potência do motor em cavalos", example = "240")
        @NotNull(message = "A potência é obrigatória")
        @Positive
        Double potencia,

        @Schema(description = "Marca do carro", example = "Honda")
        @NotBlank(message = "A Marca do carro é obrigatória")
        String marca
) {}
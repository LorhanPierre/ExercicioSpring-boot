package com.weg.exercicio.module.carro.aplication.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record CarroCreateRequestDto(
        @NotBlank(message = "O modelo é obrigatório")
        String modelo,

        @NotNull(message = "O ano do carro é obrigatório")
        @Min(value = 1885, message = "O ano do carro é inválido")
        Integer anoCarro,

        @NotNull(message = "A potência é obrigatória")
        @Positive
        Double potencia,

        @NotBlank(message = "A Marca do carro é obrigatória")
        String marca
) {
}

package com.weg.exercicio.module.carro.aplication.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CarroUpdateRequestDto(
        String modelo,
        @Min(value = 1885, message = "O ano do carro é inválido")
        Integer anoCarro,
        @Positive
        Double potencia,
        String marca
) {

}

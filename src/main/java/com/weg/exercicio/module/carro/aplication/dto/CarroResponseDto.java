package com.weg.exercicio.module.carro.aplication.dto;

import java.time.LocalDate;

public record CarroResponseDto(
        Long id,
        String modelo,
        Integer anoCarro,
        Double potencia,
        String marca
) {
}

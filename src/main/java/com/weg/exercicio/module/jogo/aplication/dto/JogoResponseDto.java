package com.weg.exercicio.module.jogo.aplication.dto;

import jakarta.persistence.Column;

public record JogoResponseDto(
        Long id,
        String nome,
        String tamanho,
        Double preco,
        String tipoJogo
) {
}

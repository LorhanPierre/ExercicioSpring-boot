package com.weg.exercicio.module.carro.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "modelo", nullable = false)
    private String modelo;

    @Column(name = "anoCarro", nullable = false)
    private Integer anoCarro;

    @Column(name = "potencia", nullable = false)
    private Double potencia;

    @Column(name = "marca", nullable = false)
    private String marca;

    public Carro(String modelo, Integer anoCarro, Double potencia, String marca) {
        this.modelo = modelo;
        this.anoCarro = anoCarro;
        this.potencia = potencia;
        this.marca = marca;
    }

    public void update(String modelo,
                       Integer anoCarro,
                       Double potencia,
                       String marca
    ) {
        if (!modelo.isBlank()) {
            this.modelo = modelo;
        }
        if (anoCarro != null) {
            this.anoCarro = anoCarro;
        }
        if (potencia != null) {
            this.potencia = potencia;
        }
        if (!marca.isBlank()) {
            this.marca = marca;
        }
    }
}

package com.weg.exercicio.module.jogo.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Jogo")
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_Jogo", nullable = false)
    private String nome;

    @Column(name = "tamanho")
    private Double tamanho;

    @Column(name = "preco", nullable = false)
    private Double preco;

    @Column(name = "tipo_jogo", nullable = false)
    private String tipoJogo;

    public Jogo(String nome, Double tamanho, Double preco, String tipoJogo) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.preco = preco;
        this.tipoJogo = tipoJogo;
    }

    public void update(
            String nome,
            Double tamanho,
            Double preco,
            String tipoJogo
    ) {
        if (!nome.isBlank()) {
            this.nome = nome;
        }
        if (tamanho != null){
            this.tamanho = tamanho;
        }
        if (preco != null) {
            this.preco = preco;
        }
        if (!tipoJogo.isBlank()){
            this.tipoJogo = tipoJogo;
        }
    }
}

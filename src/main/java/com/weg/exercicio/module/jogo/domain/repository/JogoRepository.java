package com.weg.exercicio.module.jogo.domain.repository;

import com.weg.exercicio.module.jogo.domain.entity.Jogo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JogoRepository {

    Jogo save(Jogo jogo);
    List<Jogo> findAll();
    Optional<Jogo> findById(Long id);
    void deleteById(Long id);
    Jogo save(Long id,Jogo jogo);
}

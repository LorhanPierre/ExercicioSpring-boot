package com.weg.exercicio.infra.respositories.jogo;

import com.weg.exercicio.module.jogo.domain.entity.Jogo;
import com.weg.exercicio.module.jogo.domain.repository.JogoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class JogoRepositoryAdapter implements JogoRepository {

    private final JogoJpaRepository jogoJpaRepository;

    @Override
    public Jogo save(Jogo jogo) {
        return jogoJpaRepository.save(jogo);
    }

    @Override
    public List<Jogo> findAll() {
        return jogoJpaRepository.findAll();
    }

    @Override
    public Optional<Jogo> findById(Long id) {
        return jogoJpaRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        jogoJpaRepository.deleteById(id);
    }

    @Override
    public Jogo save(Long id, Jogo jogo) {
        jogo.setId(id);
        return jogoJpaRepository.save(jogo);
    }
}

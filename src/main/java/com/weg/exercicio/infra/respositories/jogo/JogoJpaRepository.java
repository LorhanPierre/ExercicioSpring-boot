package com.weg.exercicio.infra.respositories.jogo;

import com.weg.exercicio.module.jogo.domain.entity.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoJpaRepository extends JpaRepository<Jogo, Long> {
}

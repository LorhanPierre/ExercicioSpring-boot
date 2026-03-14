package com.weg.exercicio.infra.respositories.carro;

import com.weg.exercicio.module.carro.domain.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroJpaRepository extends JpaRepository<Carro, Long> {

}

package com.weg.exercicio.module.carro.domain.repository;

import com.weg.exercicio.module.carro.domain.entity.Carro;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarroRepository {

    Carro save(Carro carro);

    List<Carro> findAll();

    Optional<Carro> findById(Long id);

    void delete(Long id);

    Carro save(Long id,Carro carro);

}

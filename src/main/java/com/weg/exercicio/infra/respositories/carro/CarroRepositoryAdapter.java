package com.weg.exercicio.infra.respositories.carro;

import com.weg.exercicio.module.carro.domain.entity.Carro;
import com.weg.exercicio.module.carro.domain.repository.CarroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class CarroRepositoryAdapter implements CarroRepository {

    private final CarroJpaRepository carroJpaRepository;

    @Override
    public Carro save(Carro carro) {
        return carroJpaRepository.save(carro);
    }

    @Override
    public List<Carro> findAll() {
        return carroJpaRepository.findAll();
    }

    @Override
    public Optional<Carro> findById(Long id) {
        return carroJpaRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        carroJpaRepository.deleteById(id);
    }

    @Override
    public Carro save(Long id, Carro carro) {
        carro.setId(id);
        return carroJpaRepository.save(carro);
    }

}

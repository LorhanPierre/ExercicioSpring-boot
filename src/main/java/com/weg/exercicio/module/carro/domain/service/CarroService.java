package com.weg.exercicio.module.carro.domain.service;

import com.weg.exercicio.module.carro.aplication.dto.CarroCreateRequestDto;
import com.weg.exercicio.module.carro.aplication.dto.CarroResponseDto;
import com.weg.exercicio.module.carro.aplication.dto.CarroUpdateRequestDto;
import com.weg.exercicio.module.carro.aplication.mapper.CarroMapper;
import com.weg.exercicio.module.carro.domain.entity.Carro;
import com.weg.exercicio.module.carro.domain.repository.CarroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CarroService {

    private final CarroRepository carroRepository;
    private final CarroMapper carroMapper;

    @Transactional
    public CarroResponseDto save(CarroCreateRequestDto carroRequest) {
        Carro newCar = carroMapper.entityToCreate(carroRequest);

        carroRepository.save(newCar);

        return carroMapper.toResponse(newCar);
    }

    public CarroResponseDto findById(Long id) {
        Carro car = carroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nenhum carro com esse ID foi encontrado"));

        return carroMapper.toResponse(car);
    }

    public List<CarroResponseDto> findAll() {
        List<Carro> carros = carroRepository.findAll();

        return carros.stream()
                .map(carroMapper::toResponse)
                .toList();
    }

    @Transactional
    public CarroResponseDto update(Long id, CarroUpdateRequestDto carroUpdate) {
        Carro novosDadosCarro = carroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nenhum carro com esse ID foi encontrado"));

        novosDadosCarro.update(
                carroUpdate.modelo(),
                carroUpdate.anoCarro(),
                carroUpdate.potencia(),
                carroUpdate.marca()
        );

        return carroMapper.toResponse(novosDadosCarro);
    }

    public void delete(Long id) {
        carroRepository.delete(id);
    }
}

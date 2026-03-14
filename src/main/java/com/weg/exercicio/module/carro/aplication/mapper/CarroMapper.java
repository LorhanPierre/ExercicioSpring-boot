package com.weg.exercicio.module.carro.aplication.mapper;

import com.weg.exercicio.module.carro.aplication.dto.CarroCreateRequestDto;
import com.weg.exercicio.module.carro.aplication.dto.CarroResponseDto;
import com.weg.exercicio.module.carro.aplication.dto.CarroUpdateRequestDto;
import com.weg.exercicio.module.carro.domain.entity.Carro;
import org.springframework.stereotype.Component;

@Component
public class CarroMapper {

    public Carro entityToCreate(CarroCreateRequestDto carroRequest){
        return new Carro(
                carroRequest.modelo(),
                carroRequest.anoCarro(),
                carroRequest.potencia(),
                carroRequest.marca()
        );
    }

    public Carro entityToUpdate(CarroUpdateRequestDto carroUpdate){
        return new Carro(
                carroUpdate.modelo(),
                carroUpdate.anoCarro(),
                carroUpdate.potencia(),
                carroUpdate.marca()
        );
    }

    public CarroResponseDto toResponse(Carro carro){
        return new CarroResponseDto(
                carro.getId(),
                carro.getModelo(),
                carro.getAnoCarro(),
                carro.getPotencia(),
                carro.getMarca()
        );
    }
}

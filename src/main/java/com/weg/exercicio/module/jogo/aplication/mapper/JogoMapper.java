package com.weg.exercicio.module.jogo.aplication.mapper;

import com.weg.exercicio.module.jogo.aplication.dto.JogoCreateRequestDto;
import com.weg.exercicio.module.jogo.aplication.dto.JogoResponseDto;
import com.weg.exercicio.module.jogo.aplication.dto.JogoUpdateRequestDto;
import com.weg.exercicio.module.jogo.domain.entity.Jogo;
import org.springframework.stereotype.Component;

@Component
public class JogoMapper {

    public Jogo EntityToCreate(JogoCreateRequestDto jogoRequest){
        return new Jogo(
                jogoRequest.nome(),
                jogoRequest.tamanhoEmMB(),
                jogoRequest.preco(),
                jogoRequest.tipoJogo()
        );
    }

    public Jogo EntityToUpdate(JogoUpdateRequestDto jogoRequest){
        return new Jogo(
                jogoRequest.nome(),
                jogoRequest.tamanhoEmMB(),
                jogoRequest.preco(),
                jogoRequest.tipoJogo()
        );
    }

    public JogoResponseDto toResponse(Jogo jogo){

        String tamanho = Double.toString(jogo.getTamanho()) + "Mb";

        if(jogo.getTamanho() >= 1000){
         tamanho = Double.toString(jogo.getTamanho() / 1000) + "Gb";
        }

        return new JogoResponseDto(
                jogo.getId(),
                jogo.getNome(),
                tamanho,
                jogo.getPreco(),
                jogo.getTipoJogo()
        );
    }
}

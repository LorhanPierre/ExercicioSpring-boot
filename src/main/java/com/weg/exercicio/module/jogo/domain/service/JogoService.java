package com.weg.exercicio.module.jogo.domain.service;

import com.weg.exercicio.module.jogo.aplication.dto.JogoCreateRequestDto;
import com.weg.exercicio.module.jogo.aplication.dto.JogoResponseDto;
import com.weg.exercicio.module.jogo.aplication.dto.JogoUpdateRequestDto;
import com.weg.exercicio.module.jogo.aplication.mapper.JogoMapper;
import com.weg.exercicio.module.jogo.domain.entity.Jogo;
import com.weg.exercicio.module.jogo.domain.repository.JogoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class JogoService {

    private final JogoRepository jogoRepository;
    private final JogoMapper jogoMapper;

    @Transactional
    public JogoResponseDto save(JogoCreateRequestDto jogoRequest){
        Jogo novoJogo = jogoMapper.EntityToCreate(jogoRequest);

        jogoRepository.save(novoJogo);

        return jogoMapper.toResponse(novoJogo);
    }

    public List<JogoResponseDto> findAll(){
        var jogos = jogoRepository.findAll();

        return jogos.stream()
                    .map(jogoMapper::toResponse)
                    .toList();
    }

    public JogoResponseDto findById(Long id) {
        Jogo jogo = jogoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nenhum jogo foi encontrado"));

        return jogoMapper.toResponse(jogo);
    }

    @Transactional
    public JogoResponseDto update(Long id,JogoUpdateRequestDto updateRequest){
        Jogo jogo = jogoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nenhum jogo foi encontrado"));

        jogo.update(
                updateRequest.nome(),
                updateRequest.tamanhoEmMB(),
                updateRequest.preco(),
                updateRequest.tipoJogo()
        );

        jogoRepository.save(id,jogo);

        return jogoMapper.toResponse(jogo);
    }

    public void delete(Long id){
        jogoRepository.deleteById(id);
    }
}

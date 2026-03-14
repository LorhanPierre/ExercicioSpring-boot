package com.weg.exercicio.module.jogo.aplication.controller;

import com.weg.exercicio.module.jogo.domain.service.JogoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/jogo")
public class JogoController {

    private final JogoService jogoService;


}

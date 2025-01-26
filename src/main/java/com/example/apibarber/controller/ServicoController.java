package com.example.apibarber.controller;

import com.example.apibarber.dto.ServicoDto;
import com.example.apibarber.model.Servico;
import com.example.apibarber.service.ServicoService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/servicos")
@Validated
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public Servico criarServico(@RequestBody @Valid ServicoDto servico) {
        Servico novoServico = modelMapper.map(servico, Servico.class);

        return servicoService.criarServico(novoServico);
    }
}

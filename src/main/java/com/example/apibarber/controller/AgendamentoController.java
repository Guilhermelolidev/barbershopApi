package com.example.apibarber.controller;

import com.example.apibarber.dto.AgendamentoDto;
import com.example.apibarber.model.Agendamento;
import com.example.apibarber.service.AgendamentoService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/agendamentos")
@Validated
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public Page<Agendamento> listarAgendamentos(
            @RequestParam(required = false) Long clienteId,
            @RequestParam(required = false) LocalDateTime dataInicio,
            @RequestParam(required = false) LocalDateTime dataFim,
            Pageable  pageable
    ) {
        return agendamentoService.listarAgendamentos(clienteId, dataInicio, dataFim, pageable);
    }

    @PostMapping
    public Agendamento criarAgendamento(@RequestBody @Valid AgendamentoDto agendamento) {
        Agendamento novoAgendamento = modelMapper.map(agendamento, Agendamento.class);

        return agendamentoService.criarAgendamento(novoAgendamento);
    }

    @GetMapping("/{id}")
    public Agendamento buscarAgendamentoPorId(@PathVariable Long id) {
        return agendamentoService.buscarAgendamentoPorId(id);
    }
}

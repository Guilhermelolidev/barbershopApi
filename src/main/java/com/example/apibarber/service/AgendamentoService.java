package com.example.apibarber.service;

import com.example.apibarber.model.Agendamento;
import com.example.apibarber.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public Page<Agendamento> listarAgendamentos(Long clienteId, LocalDateTime dataInicio, LocalDateTime dataFim, Pageable pageable) {

        if(dataInicio != null && dataInicio.isAfter(dataFim)) {
            throw new IllegalArgumentException("Data final deve ser maior que data inicial");
        }

        if(dataInicio != null && dataFim != null && clienteId != null) {
            return agendamentoRepository.findAllByDataHoraAndClienteId(dataInicio, dataFim, clienteId, pageable);
        } else if(clienteId != null){
            return agendamentoRepository.findAllByClienteId(clienteId, pageable);
        } else {
            return agendamentoRepository.findAll(pageable);
        }
    }

    public Agendamento criarAgendamento(Agendamento agendamento) {
        boolean horarioOcupado = agendamentoRepository.findByDataHora(agendamento.getDataHora()).isPresent();
        if(horarioOcupado) {
             throw new RuntimeException("Horário já ocupado, escolha outro.");
        }

        return agendamentoRepository.save(agendamento);
    }

    public Agendamento buscarAgendamentoPorId(Long id) {
        return agendamentoRepository.findById(id).orElse(null);
    }
}

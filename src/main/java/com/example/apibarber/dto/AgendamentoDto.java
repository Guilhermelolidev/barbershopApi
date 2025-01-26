package com.example.apibarber.dto;

import com.example.apibarber.model.Cliente;
import com.example.apibarber.model.Servico;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AgendamentoDto {

    @NotNull(message = "Cliente é obrigatório")
    private Cliente cliente;

    @NotNull(message = "Serviço é obrigatório")
    private Servico servico;

    @NotNull(message = "Data é obrigatório")
    private LocalDateTime dataHora;
}

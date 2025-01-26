package com.example.apibarber.service;

import com.example.apibarber.model.Servico;
import com.example.apibarber.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoService {

    @Autowired
    private ServiceRepository serviceRepository;

    public Servico criarServico(Servico servico) {
        return serviceRepository.save(servico);
    }
}

package com.example.apibarber.service;

import com.example.apibarber.dto.ClienteDto;
import com.example.apibarber.model.Cliente;
import com.example.apibarber.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Page<Cliente> listarClientes(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}

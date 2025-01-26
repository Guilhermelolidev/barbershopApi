package com.example.apibarber.controller;

import com.example.apibarber.dto.ClienteDto;
import com.example.apibarber.model.Cliente;
import com.example.apibarber.service.ClienteService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
@Validated
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public Page<Cliente> listarClientes(Pageable pageable) {
        return clienteService.listarClientes(pageable);
    }

    @PostMapping
    public Cliente criarCliente(@RequestBody @Valid ClienteDto cliente) {
        Cliente novoCliente = modelMapper.map(cliente, Cliente.class);

        return clienteService.criarCliente(novoCliente);
    }

}

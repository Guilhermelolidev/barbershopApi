package com.example.apibarber.repository;

import com.example.apibarber.model.Agendamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    Optional<Agendamento> findByDataHora(LocalDateTime dataHora);

    Page<Agendamento> findAllByClienteId(Long clienteId, Pageable pageable);

    Page<Agendamento> findAll(Pageable pageable);

    @Query("SELECT a FROM Agendamento a WHERE a.dataHora BETWEEN :inicio AND :fim AND a.cliente.id = :clienteId")
    Page<Agendamento> findAllByDataHoraAndClienteId(LocalDateTime inicio, LocalDateTime fim, Long clienteId, Pageable pageable);

}

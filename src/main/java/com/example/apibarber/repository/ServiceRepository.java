package com.example.apibarber.repository;

import com.example.apibarber.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Servico, Long> {
}

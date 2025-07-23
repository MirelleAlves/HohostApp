package br.edu.cads.hohostapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.cads.hohostapp.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}

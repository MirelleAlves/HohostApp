package br.edu.cads.hohostapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.cads.hohostapp.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    
}



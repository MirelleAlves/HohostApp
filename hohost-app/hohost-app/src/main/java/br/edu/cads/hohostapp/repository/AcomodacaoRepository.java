package br.edu.cads.hohostapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.cads.hohostapp.model.Acomodacao;

public interface AcomodacaoRepository extends JpaRepository<Acomodacao, Long> {
    
}

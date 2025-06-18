package br.edu.cads.hohostapp.model;

import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class Anfitriao {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String estado;
    private String cidadeAtuação;

    @OneToMany(mappedBy = "anfitriao")
    private List<Acomodacao> acomodacoes;
}

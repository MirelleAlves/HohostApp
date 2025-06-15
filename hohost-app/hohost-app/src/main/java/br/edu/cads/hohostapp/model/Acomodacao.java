package br.edu.cads.hohostapp.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Acomodacao {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private String titulo;
    private String descricao;
    private String endereco;
    private String cidade;
    private String estado;
    private String tipo;
    private Double precoPorNoite;
    private Integer quantidadeQuartos;
    private Integer quantidadeBanheiros;
    private Integer capacidade;
    private Boolean wifi;
    private Boolean estacionamento;
    private Boolean animaisPermitidos;
    private Boolean disponivel;

    @ManyToOne
    @JoinColumn(name = "anfitriao_id")
    private Anfitriao anfitriao;

}

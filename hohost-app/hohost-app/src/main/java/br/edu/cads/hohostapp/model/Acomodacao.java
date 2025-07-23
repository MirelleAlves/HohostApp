package br.edu.cads.hohostapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
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

    public Acomodacao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getPrecoPorNoite() {
        return precoPorNoite;
    }

    public void setPrecoPorNoite(Double precoPorNoite) {
        this.precoPorNoite = precoPorNoite;
    }

    public Integer getQuantidadeQuartos() {
        return quantidadeQuartos;
    }

    public void setQuantidadeQuartos(Integer quantidadeQuartos) {
        this.quantidadeQuartos = quantidadeQuartos;
    }

    public Integer getQuantidadeBanheiros() {
        return quantidadeBanheiros;
    }

    public void setQuantidadeBanheiros(Integer quantidadeBanheiros) {
        this.quantidadeBanheiros = quantidadeBanheiros;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public boolean getWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean getEstacionamento() {
        return estacionamento;
    }

    public void setEstacionamento(boolean estacionamento) {
        this.estacionamento = estacionamento;
    }

    public boolean getAnimaisPermitidos() {
        return animaisPermitidos;
    }

    public void setAnimaisPermitidos(boolean animaisPermitidos) {
        this.animaisPermitidos = animaisPermitidos;
    }

    public boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

}

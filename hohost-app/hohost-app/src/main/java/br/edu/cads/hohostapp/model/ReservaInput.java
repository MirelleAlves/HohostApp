package br.edu.cads.hohostapp.model;

import jakarta.persistence.Entity;

@Entity
public class ReservaInput {
    private Long idCliente;
    private Long idAcomodacao;
    private String dataEntrada;
    private String dataSaida;
    private String formaPagamento;

    public ReservaInput() {
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdAcomodacao() {
        return idAcomodacao;
    }

    public void setIdAcomodacao(Long idAcomodacao) {
        this.idAcomodacao = idAcomodacao;
    }
    
    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}
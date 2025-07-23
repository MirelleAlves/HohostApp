package br.edu.cads.hohostapp.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Reserva {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private String dataEntrada;
    private String dataSaida;
    private String formaPagamento;
    public enum StatusReserva {
        PENDENTE,        // Reserva criada, aguardando confirmação
        CONFIRMADA,      // Reserva confirmada pelo anfitrião ou sistema
        REJEITADA,       // Anfitrião recusou a reserva
        CANCELADA,       // Cliente ou anfitrião cancelou
        CHECK_IN,        // Cliente realizou o check-in
        CHECK_OUT,       // Cliente finalizou a estadia
        NAO_APARECEU,    
        CONCLUIDA        
    }

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Acomodacao acomodacao;

    public Reserva() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Acomodacao getAcomodacao() {
        return acomodacao;
    }

    public void setAcomodacao(Acomodacao acomodacao) {
        this.acomodacao = acomodacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}

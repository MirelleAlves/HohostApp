package br.edu.cads.hohostapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Reserva {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private String dataEntrada;
    private String dataSaida;
    private String formaPagamento;
    private StatusReserva status;
    public enum StatusReserva {
        PENDENTE (1),        // Reserva criada, aguardando confirmação
        CONFIRMADA (2),      // Reserva confirmada pelo anfitrião ou sistema
        REJEITADA (3),       // Anfitrião recusou a reserva
        CANCELADA (4),       // Cliente ou anfitrião cancelou
        CHECK_IN (5),        // Cliente realizou o check-in
        CHECK_OUT (6),       // Cliente finalizou a estadia
        NAO_APARECEU (7),    
        CONCLUIDA (8);

        private int status;

        StatusReserva(int status) {
            this.status = status;
        }   
        
    }
    

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "acomodacao_id")
    private Acomodacao acomodacao;

    @ManyToOne
    @JoinColumn(name = "anfitriao_id")
    private Anfitriao anfitriao;

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

    public StatusReserva getStatus() {
            return status;
        }

    public void setStatus(StatusReserva status) {
            this.status = status;
        }
    
}

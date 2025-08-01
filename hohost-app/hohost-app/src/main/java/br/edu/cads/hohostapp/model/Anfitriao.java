package br.edu.cads.hohostapp.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Anfitriao {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String estado;
    private String cidadeAtuacao;

    @OneToMany(mappedBy = "anfitriao")
    private List<Acomodacao> acomodacoes;

    @OneToMany(mappedBy = "anfitriao")
    private List<Reserva> reservas;

     public Anfitriao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidadeAtuacao() {
        return cidadeAtuacao;
    }

    public void setCidadeAtuacao(String cidadeAtuacao) {
        this.cidadeAtuacao = cidadeAtuacao;
    }
}

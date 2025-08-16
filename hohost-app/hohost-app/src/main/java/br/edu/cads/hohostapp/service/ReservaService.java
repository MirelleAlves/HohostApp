package br.edu.cads.hohostapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.cads.hohostapp.model.Acomodacao;
import br.edu.cads.hohostapp.model.Cliente;
import br.edu.cads.hohostapp.model.Reserva;
import br.edu.cads.hohostapp.repository.AcomodacaoRepository;
import br.edu.cads.hohostapp.repository.ClienteRepository;
import br.edu.cads.hohostapp.repository.ReservaRepository;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AcomodacaoRepository acomodacaoRepository;

    public List<Reserva> listarTodas() {
        return repository.findAll();
    }

    public Optional<Reserva> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Reserva reservar(Long idCliente, Long idAcomodacao, String dataEntrada, String dataSaida, String formaPagamento) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Acomodacao acomodacao = acomodacaoRepository.findById(idAcomodacao)
                .orElseThrow(() -> new RuntimeException("Acomodação não encontrada"));
        
        if (Boolean.FALSE.equals(acomodacao.getDisponivel())) {
            throw new RuntimeException("Acomodação indisponível para reserva");
        }

        Reserva reserva = new Reserva();
        reserva.setCliente(cliente);
        reserva.setAcomodacao(acomodacao);
        reserva.setDataEntrada(dataEntrada);
        reserva.setDataSaida(dataSaida);
        reserva.setFormaPagamento(formaPagamento);
        reserva.setStatus(Reserva.StatusReserva.PENDENTE);
        return repository.save(reserva);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Optional<Reserva> atualizar(@PathVariable Long id, @RequestBody Reserva dadosAtualizados) {
        Optional<Reserva> existente = repository.findById(id);

        if (existente.isPresent()) {
            Reserva reserva = existente.get();
            reserva.setDataEntrada(dadosAtualizados.getDataEntrada());
            reserva.setDataSaida(dadosAtualizados.getDataSaida());
            reserva.setFormaPagamento(dadosAtualizados.getFormaPagamento());
            reserva.setAcomodacao(dadosAtualizados.getAcomodacao());
            reserva.setStatus(dadosAtualizados.getStatus());
            
             return Optional.of(repository.save(reserva));
        }

        return Optional.empty();
    }
}


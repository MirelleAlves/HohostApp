package br.edu.cads.hohostapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.cads.hohostapp.model.Reserva;
import br.edu.cads.hohostapp.repository.ReservaRepository;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository repository;

    public List<Reserva> listarTodas() {
        return repository.findAll();
    }

    public Optional<Reserva> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Reserva salvar(Reserva Reserva) {
        return repository.save(Reserva);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

}


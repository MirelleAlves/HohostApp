package br.edu.cads.hohostapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.cads.hohostapp.model.Cliente;
import br.edu.cads.hohostapp.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public List<Cliente> listarTodas() {
        return repository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Cliente salvar(Cliente Cliente) {
        return repository.save(Cliente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

}
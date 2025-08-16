package br.edu.cads.hohostapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    @PutMapping("/{id}")
    public Optional<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente dadosAtualizados) {
        Optional<Cliente> existente = repository.findById(id);

        if (existente.isPresent()) {
            Cliente cliente = existente.get();
            cliente.setNome(dadosAtualizados.getNome());
            cliente.setTelefone(dadosAtualizados.getTelefone());
            cliente.setEmail(dadosAtualizados.getEmail());
            cliente.setCpf(dadosAtualizados.getCpf());
            
             return Optional.of(repository.save(cliente));
        }

        return Optional.empty();
    }

}
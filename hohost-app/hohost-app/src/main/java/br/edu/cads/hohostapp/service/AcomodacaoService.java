package br.edu.cads.hohostapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.cads.hohostapp.model.Acomodacao;
import br.edu.cads.hohostapp.repository.AcomodacaoRepository;

@Service
public class AcomodacaoService {
    @Autowired
    private AcomodacaoRepository repository;

    public List<Acomodacao> listarTodas() {
        return repository.findAll();
    }

    public Optional<Acomodacao> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Acomodacao salvar(Acomodacao acomodacao) {
        return repository.save(acomodacao);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

}

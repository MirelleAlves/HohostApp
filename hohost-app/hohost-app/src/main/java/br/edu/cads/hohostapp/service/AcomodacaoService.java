package br.edu.cads.hohostapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    @PutMapping("/{id}")
    public Optional<Acomodacao> atualizar(@PathVariable Long id, @RequestBody Acomodacao atualizacaoAcomodacao) {
        Optional<Acomodacao> existente = repository.findById(id);

        if (existente.isPresent()) {
            Acomodacao acomodacao = existente.get();
            acomodacao.setTitulo(atualizacaoAcomodacao.getTitulo());
            acomodacao.setDescricao(atualizacaoAcomodacao.getDescricao());
            acomodacao.setEndereco(atualizacaoAcomodacao.getEndereco());
            acomodacao.setCidade(atualizacaoAcomodacao.getCidade());
            acomodacao.setEstado(atualizacaoAcomodacao.getEstado());
            acomodacao.setTipo(atualizacaoAcomodacao.getTipo());
            acomodacao.setPrecoPorNoite(atualizacaoAcomodacao.getPrecoPorNoite());
            acomodacao.setQuantidadeQuartos(atualizacaoAcomodacao.getQuantidadeQuartos());
            acomodacao.setQuantidadeBanheiros(atualizacaoAcomodacao.getQuantidadeBanheiros());
            acomodacao.setCapacidade(atualizacaoAcomodacao.getCapacidade());
            acomodacao.setWifi(atualizacaoAcomodacao.getWifi());
            acomodacao.setEstacionamento(atualizacaoAcomodacao.getEstacionamento());
            acomodacao.setAnimaisPermitidos(atualizacaoAcomodacao.getAnimaisPermitidos());
            acomodacao.setDisponivel(atualizacaoAcomodacao.getDisponivel());


            return Optional.of(repository.save(acomodacao));
        }

        return Optional.empty();
    }

}

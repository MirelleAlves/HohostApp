package br.edu.cads.hohostapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.cads.hohostapp.model.Anfitriao;
import br.edu.cads.hohostapp.repository.AnfitriaoRepository;

@Service
public class AnfitriaoService {
    @Autowired
    private AnfitriaoRepository repository;

    public List<Anfitriao> listarTodas() {
        return repository.findAll();
    }

    public Optional<Anfitriao> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Anfitriao salvar(Anfitriao Anfitriao) {
        return repository.save(Anfitriao);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Optional<Anfitriao> atualizar(@PathVariable Long id, @RequestBody Anfitriao dadosAtualizados) {
        Optional<Anfitriao> existente = repository.findById(id);

        if (existente.isPresent()) {
            Anfitriao anfitriao = existente.get();
            anfitriao.setNome(dadosAtualizados.getNome());
            anfitriao.setTelefone(dadosAtualizados.getTelefone());
            anfitriao.setEmail(dadosAtualizados.getEmail());
            anfitriao.setEstado(dadosAtualizados.getEstado());
            anfitriao.setCidadeAtuacao(dadosAtualizados.getCidadeAtuacao());
            
             return Optional.of(repository.save(anfitriao));
        }

        return Optional.empty();
    }



}
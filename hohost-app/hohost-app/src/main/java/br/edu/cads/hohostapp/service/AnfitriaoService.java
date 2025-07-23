package br.edu.cads.hohostapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
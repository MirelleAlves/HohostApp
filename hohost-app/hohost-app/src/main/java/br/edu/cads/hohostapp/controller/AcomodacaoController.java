package br.edu.cads.hohostapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.cads.hohostapp.model.Acomodacao;
import br.edu.cads.hohostapp.service.AcomodacaoService;

@RestController
@RequestMapping("/api/acomodacoes")
public class AcomodacaoController {
    @Autowired
    private AcomodacaoService service;

    @GetMapping
    public List<Acomodacao> listarTodas() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Acomodacao> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Acomodacao criar(@RequestBody Acomodacao acomodacao) {
        return service.salvar(acomodacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Acomodacao> atualizar(@PathVariable Long id, @RequestBody Acomodacao atualizacaoAcomodacao) {
        Optional<Acomodacao> existente = service.buscarPorId(id);

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

            Acomodacao atualizada = service.salvar(acomodacao);
            return ResponseEntity.ok(atualizada);
        }

        return ResponseEntity.notFound().build();
    }
}

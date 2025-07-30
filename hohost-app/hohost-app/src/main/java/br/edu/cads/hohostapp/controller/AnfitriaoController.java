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

import br.edu.cads.hohostapp.model.Anfitriao;
import br.edu.cads.hohostapp.service.AnfitriaoService;

@RestController
@RequestMapping("/api/anfitrioes")
public class AnfitriaoController {
    @Autowired
    private AnfitriaoService service;

    @GetMapping
    public List<Anfitriao> listarTodas() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Anfitriao> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Anfitriao criar(@RequestBody Anfitriao Anfitriao) {
        return service.salvar(Anfitriao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Anfitriao> atualizar(@PathVariable Long id, @RequestBody Anfitriao dadosAtualizados) {
        Optional<Anfitriao> existente = service.buscarPorId(id);

        if (existente.isPresent()) {
            Anfitriao anfitriao = existente.get();
            anfitriao.setNome(dadosAtualizados.getNome());
            anfitriao.setTelefone(dadosAtualizados.getTelefone());
            anfitriao.setEmail(dadosAtualizados.getEmail());
            anfitriao.setEstado(dadosAtualizados.getEstado());
            anfitriao.setCidadeAtuacao(dadosAtualizados.getCidadeAtuacao());
            return ResponseEntity.ok(service.salvar(anfitriao));
        }

        return ResponseEntity.notFound().build();
    }

}

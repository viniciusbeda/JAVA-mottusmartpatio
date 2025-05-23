package com.mottu.api.controller;

import com.mottu.api.model.Manutencao;
import com.mottu.api.service.ManutencaoService;
import jakarta.validation.Valid;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manutencoes")
public class ManutencaoController {

    private final ManutencaoService service;

    public ManutencaoController(ManutencaoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Manutencao>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manutencao> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    @CacheEvict(value = "manutencoes", allEntries = true)
    public ResponseEntity<Manutencao> salvar(@Valid @RequestBody Manutencao manutencao) {
        Manutencao salva = service.salvar(manutencao);
        return ResponseEntity.status(201).body(salva);
    }

    @PutMapping("/{id}")
    @CacheEvict(value = "manutencoes", allEntries = true)
    public ResponseEntity<Manutencao> atualizar(@PathVariable Long id, @Valid @RequestBody Manutencao manutencao) {
        Manutencao atualizada = service.atualizar(id, manutencao);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(value = "manutencoes", allEntries = true)
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

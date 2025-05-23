package com.mottu.api.controller;

import com.mottu.api.model.Moto;
import com.mottu.api.service.MotoService;
import jakarta.validation.Valid;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motos")
public class MotoController {

    private final MotoService service;

    public MotoController(MotoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Moto>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Moto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    @CacheEvict(value = "motos", allEntries = true)
    public ResponseEntity<Moto> salvar(@Valid @RequestBody Moto moto) {
        Moto salva = service.salvar(moto);
        return ResponseEntity.status(201).body(salva);
    }

    @PutMapping("/{id}")
    @CacheEvict(value = "motos", allEntries = true)
    public ResponseEntity<Moto> atualizar(@PathVariable Long id, @Valid @RequestBody Moto moto) {
        Moto atualizada = service.atualizar(id, moto);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(value = "motos", allEntries = true)
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

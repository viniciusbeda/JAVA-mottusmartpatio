package com.mottu.api.service;

import com.mottu.api.exception.ResourceNotFoundException;
import com.mottu.api.model.Moto;
import com.mottu.api.repository.MotoRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoService {

    private final MotoRepository repository;

    public MotoService(MotoRepository repository) {
        this.repository = repository;
    }

    @Cacheable("motos")
    public List<Moto> listarTodos() {
        return repository.findAll();
    }

    public Moto buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Moto não encontrada com ID: " + id));
    }

    public Moto salvar(Moto moto) {
        return repository.save(moto);
    }

    public Moto atualizar(Long id, Moto motoAtualizada) {
        Moto moto = buscarPorId(id);
        moto.setPlaca(motoAtualizada.getPlaca());
        moto.setModelo(motoAtualizada.getModelo());
        moto.setStatus(motoAtualizada.getStatus());
        return repository.save(moto);
    }

    public void deletar(Long id) {
        Moto moto = buscarPorId(id);
        repository.delete(moto);
    }
}

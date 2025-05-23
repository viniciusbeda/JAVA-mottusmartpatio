package com.mottu.api.service;

import com.mottu.api.exception.ResourceNotFoundException;
import com.mottu.api.model.Manutencao;
import com.mottu.api.repository.ManutencaoRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManutencaoService {

    private final ManutencaoRepository repository;

    public ManutencaoService(ManutencaoRepository repository) {
        this.repository = repository;
    }

    @Cacheable("manutencoes")
    public List<Manutencao> listarTodas() {
        return repository.findAll();
    }

    public Manutencao buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Manutenção não encontrada com ID: " + id));
    }

    public Manutencao salvar(Manutencao manutencao) {
        return repository.save(manutencao);
    }

    public Manutencao atualizar(Long id, Manutencao manutencaoAtualizada) {
        Manutencao manutencao = buscarPorId(id);
        manutencao.setDescricao(manutencaoAtualizada.getDescricao());
        manutencao.setData(manutencaoAtualizada.getData());
        manutencao.setMoto(manutencaoAtualizada.getMoto());
        return repository.save(manutencao);
    }

    public void deletar(Long id) {
        Manutencao manutencao = buscarPorId(id);
        repository.delete(manutencao);
    }
}

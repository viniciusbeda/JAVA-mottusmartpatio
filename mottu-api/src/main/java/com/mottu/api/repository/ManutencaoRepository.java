package com.mottu.api.repository;

import com.mottu.api.model.Manutencao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {
    // Pode adicionar métodos de busca customizados aqui também.
}

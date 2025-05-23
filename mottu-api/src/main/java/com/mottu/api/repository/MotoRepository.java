package com.mottu.api.repository;

import com.mottu.api.model.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Long> {
    // Pode adicionar métodos de busca customizados aqui, se quiser.
}

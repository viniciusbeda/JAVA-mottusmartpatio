package com.mottu.api.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.io.Serializable;

@Entity
public class Manutencao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "moto_id")
    private Moto moto;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public Moto getMoto() { return moto; }
    public void setMoto(Moto moto) { this.moto = moto; }
}

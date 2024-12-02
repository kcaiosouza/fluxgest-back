package com.unifacisa.fluxgest.Entity;

import jakarta.persistence.*;

@Entity
public class Log {
    public enum Tipo {
        ENTRADA,
        SAIDA
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false)
    private String produto_id;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    @Column(nullable = false)
    private int quantidade;
    @Column(nullable = false)
    private String empresa_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(String produto_id) {
        this.produto_id = produto_id;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getEmpresa_id() {
        return empresa_id;
    }

    public void setEmpresa_id(String empresa_id) {
        this.empresa_id = empresa_id;
    }
}

package com.unifacisa.fluxgest.Entity;

import jakarta.persistence.*;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private float preco;
    @Column(nullable = false, unique = true)
    private String codigo_barras;
    @Column(nullable = false)
    private int quantidade_estoque;
    @Column(nullable = false)
    private String empresa_id;

    public String getEmpresa_id() {
        return empresa_id;
    }

    public void setEmpresa_id(String empresa_id) {
        this.empresa_id = empresa_id;
    }

    public int getQuantidade_estoque() {
        return quantidade_estoque;
    }

    public void setQuantidade_estoque(int quantidade_estoque) {
        this.quantidade_estoque = quantidade_estoque;
    }

    public String getCodigo_barras() {
        return codigo_barras;
    }

    public void setCodigo_barras(String codigo_barras) {
        this.codigo_barras = codigo_barras;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

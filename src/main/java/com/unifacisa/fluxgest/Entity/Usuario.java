package com.unifacisa.fluxgest.Entity;

import jakarta.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String data_nascimento;
    private String cargo;
    @Column(nullable = false)
    private String empresa_id;
    @Column(nullable = false)
    private String senha;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmpresa_id() {
        return empresa_id;
    }

    public void setEmpresa_id(String empresa_id) {
        this.empresa_id = empresa_id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

package com.example.jpah2demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    private String email;
    @OneToMany(mappedBy = "cliente")
    private List<Telefone> telefones;
    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos;

    public Cliente() {
    }

    public Cliente(Long id, String nome, int idade, String email, List<Telefone> telefones, List<Endereco> enderecos) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.telefones = telefones;
        this.enderecos = enderecos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}

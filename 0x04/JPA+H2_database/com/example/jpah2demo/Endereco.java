package com.example.jpah2demo.model;

import javax.persistence.*;

@Entity
@Table(name = "enderecos")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String endereco;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    @ManyToOne
    @JoinColumn(name="cliente_id", nullable=false)
    private Cliente cliente;
}

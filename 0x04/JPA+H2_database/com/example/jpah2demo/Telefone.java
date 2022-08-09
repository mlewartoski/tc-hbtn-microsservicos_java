package com.example.jpah2demo.model;

import javax.persistence.*;

@Entity
@Table(name = "telefones")
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int ddd;
    private String numero;
    @ManyToOne
    @JoinColumn(name="cliente_id", nullable=false)
    private Cliente cliente;

}

package com.pratica.sistemaDeVendas.model;

import java.io.Serializable;

public class Lanche implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private double preco;
    private int id;

    public Lanche(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // gets e sets

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    public void setPreco(double novoPreco) {
        this.preco = novoPreco;
    }

    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return " nome " + getNome() +
                ", preco " + getPreco();
    }

}

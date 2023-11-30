package com.pratica.sistemadevendas.model;

public class Lanche {
    private String nome;
    private double preco;
    private int id;

    public Lanche(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
        
    }

    //gets e sets

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
    
}





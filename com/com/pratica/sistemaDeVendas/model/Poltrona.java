package com.pratica.sistemaDeVendas.model;

import java.io.Serializable;

public class Poltrona implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private int numero;
    private boolean disponibilidade;

    
    public Poltrona(int numero, boolean disponibilidade) {
        this.numero = numero;
        this.disponibilidade = disponibilidade;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Método para exibir informações da poltrona
    public void exibirInformacoes() {
        System.out.println("Poltrona número: " + numero);
        System.out.println("Disponibilidade: " + (disponibilidade ? "Disponível" : "Indisponível"));
    }
}

package com.pratica.sistemadevendas.model;

public class Poltrona {
    // Atributos
    private int numero;
    private String tipo;
    private boolean disponibilidade;

    // Construtor
    public Poltrona(int numero, String tipo, boolean disponibilidade) {
        this.numero = numero;
        this.tipo = tipo;
        this.disponibilidade = disponibilidade;
    }

    // Getters e Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    // Método para exibir informações da poltrona
    public void exibirInformacoes() {
        System.out.println("Poltrona número: " + numero);
        System.out.println("Tipo: " + tipo);
        System.out.println("Disponibilidade: " + (disponibilidade ? "Disponível" : "Indisponível"));
    }
}

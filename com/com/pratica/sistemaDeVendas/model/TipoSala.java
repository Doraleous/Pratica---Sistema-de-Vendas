package com.pratica.sistemaDeVendas.model;

public enum TipoSala {
    _3D(1, "3D"),
    XD(2, "XD"),
    XD3D(3, "XD3D"),
    COMUM(4, "COMUM");

    private final int id;
    private final String nome;

    TipoSala(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}

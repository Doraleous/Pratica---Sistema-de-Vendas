package com.pratica.sistemaDeVendas.controller;

import java.util.ArrayList;

public class LancheController {
    private final LancheDAO lancheDAO;

    public LancheController() {
        this.lancheDAO = new LancheDAO();
    }

    public String cadastrarLanche(Lanche lanche) {
        return lancheDAO.cadastrarLanche(lanche);
    }

    public ArrayList<Lanche> listarLanches() {
        return lancheDAO.listarLanches();
    }

    public boolean atualizarLanche(String nome, double preco) {
        return lancheDAO.atualizarLanche(nome, preco);
    }

    public boolean lancheExiste(String nome) {
        return lancheDAO.lancheExiste(nome);
    }

    public long buscarLanche(String nome) {
        return lancheDAO.buscarLanche(nome);
    }

    public boolean deletarLanche(String nome) {
        return lancheDAO.deletarLanche(nome);
    }
}

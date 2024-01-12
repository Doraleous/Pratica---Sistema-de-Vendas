package com.pratica.sistemaDeVendas.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pratica.sistemaDeVendas.model.Sessao;
import com.pratica.sistemaDeVendas.model.dao.SessaoDAO;
import com.pratica.sistemaDeVendas.view.Aplicacao;

public class SessaoController {

    private SessaoDAO sessaoDAO;
    private Aplicacao aplicacao;
    private AdministradorController admController;

    public SessaoController(Aplicacao aplicacao) {
        this.sessaoDAO = new SessaoDAO(this.aplicacao);

        this.aplicacao = aplicacao;
        this.admController = this.aplicacao.getAdministradorController();
    }

    public ArrayList<Sessao> listarSessoesDisponiveis() throws SQLException {
        return sessaoDAO.listarSessoesDisponiveis();
    }

    public void cadastrarSessao() throws SQLException {
        sessaoDAO = new SessaoDAO(aplicacao);
        sessaoDAO.cadastrarSessao();
    }

    public void deletarSessao(Sessao sessao) throws SQLException {
        sessaoDAO.deletarSessao(sessao);
    }

    public void atualizarSessao(Sessao sessao) throws SQLException {
        sessaoDAO.atualizarSessao(sessao);
    }

}

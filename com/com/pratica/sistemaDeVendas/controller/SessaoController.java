package com.pratica.sistemadevendas.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.pratica.sistemadevendas.model.Filme;
import com.pratica.sistemadevendas.model.Sessao;
import com.pratica.sistemadevendas.model.dao.SessaoDAO;
import com.pratica.sistemadevendas.view.Aplicacao;

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
        sessaoDAO.cadastrarSessao();
    }

    public void deletarSessao(Sessao sessao) throws SQLException {
        sessaoDAO.deletarSessao(sessao);
    }

    public void atualizarSessao(Sessao sessao) throws SQLException {
        sessaoDAO.atualizarSessao(sessao);
    }

}

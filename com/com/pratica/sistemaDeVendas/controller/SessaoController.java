package com.pratica.sistemadevendas.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.pratica.sistemadevendas.model.Filme;
import com.pratica.sistemadevendas.model.Sessao;
import com.pratica.sistemadevendas.model.dao.SessaoDAO;

public class SessaoController {

    private SessaoDAO sessaoDAO;

    public SessaoController() {
        this.sessaoDAO = new SessaoDAO();
    }

    public ArrayList<String> listarSessoesDisponiveis() throws SQLException {
        return sessaoDAO.listarSessoesDisponiveis();
    }

    public void cadastrarSessao(Date dataInicio, Filme filmeEmCartaz) throws SQLException {
        Sessao novaSessao = new Sessao(dataInicio, filmeEmCartaz);
        sessaoDAO.cadastrarSessao(novaSessao);
    }

}

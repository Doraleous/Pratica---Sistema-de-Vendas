package com.pratica.sistemadevendas.controller;

import com.pratica.sistemadevendas.model.dao.UsuarioEstudanteDAO;
import com.pratica.sistemadevendas.view.Aplicacao;

public class UsuarioEstudanteController {
    private Aplicacao aplicacao;
    private UsuarioEstudanteDAO usuarioEstudanteDAO;

    public UsuarioEstudanteController(Aplicacao aplicacao) {
        this.aplicacao = aplicacao;
        usuarioEstudanteDAO = new UsuarioEstudanteDAO();
    }
}

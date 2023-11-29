package com.pratica.sistemadevendas.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.pratica.sistemadevendas.model.Administrador;
import com.pratica.sistemadevendas.model.Filme;
import com.pratica.sistemadevendas.model.Usuario;
import com.pratica.sistemadevendas.model.UsuarioComum;
import com.pratica.sistemadevendas.model.UsuarioCritico;
import com.pratica.sistemadevendas.model.UsuarioEstudante;
import com.pratica.sistemadevendas.model.dao.AdministradorDAO;
import com.pratica.sistemadevendas.model.dao.UsuarioDAO;
import com.pratica.sistemadevendas.view.Aplicacao;

public class AdministradorController {

    private Aplicacao aplicacao;

    public AdministradorController(Aplicacao aplicacao) {
        this.aplicacao = aplicacao;

    }

    public boolean isAdministrador(long idUsuario) throws SQLException {
        AdministradorDAO administradorDAO = new AdministradorDAO();
        return administradorDAO.isAdministrador(idUsuario);
    }

    public boolean cadastrarUsuario() {
        return false;
    }

    public boolean cadastrarFilme(String titulo) {
        return false;
    }

    public boolean usuarioExiste(String email) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.usuarioExiste(email);
    }

}

package com.pratica.sistemadevendas.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pratica.sistemadevendas.model.Filme;
import com.pratica.sistemadevendas.model.Usuario;
import com.pratica.sistemadevendas.model.UsuarioComum;
import com.pratica.sistemadevendas.model.dao.UsuarioComumDAO;

public class UsuarioComumController {

    public boolean isUsuarioComum(long idUsuario) throws SQLException {
        UsuarioComumDAO usuarioComumDAO = new UsuarioComumDAO();
        return usuarioComumDAO.isUsuarioComum(idUsuario);
    }

}

package com.pratica.sistemaDeVendas.view;

import java.sql.SQLException;

import com.pratica.sistemaDeVendas.model.dao.UsuarioDAO;

public class teste {
    public static void main(String[] args) throws SQLException {
        /*
         * UsuarioDAO user= new UsuarioDAO();
         * ArrayList<Usuario> usuarios = user.listarUsuario();
         * for (Usuario usuario : usuarios) {
         * System.out.println(usuario);
         * }
         */
        UsuarioDAO user = new UsuarioDAO();
        String email = "admin@cinecap.cm";
        boolean encontrou = user.usuarioExiste(email);
        System.out.println(encontrou);
    }
}

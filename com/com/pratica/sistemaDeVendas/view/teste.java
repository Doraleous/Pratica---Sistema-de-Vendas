package com.pratica.sistemadevendas.view;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pratica.sistemadevendas.model.Usuario;
import com.pratica.sistemadevendas.model.UsuarioDAO;

public class teste {
    public static void main(String[] args) throws SQLException {
        /*UsuarioDAO user= new UsuarioDAO();
        ArrayList<Usuario> usuarios = user.listarUsuario();
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }*/
        UsuarioDAO user= new UsuarioDAO();
        String email = "admin@cinecap.cm";
        boolean encontrou = user.usuarioExiste(email);
        System.out.println(encontrou);
    }
}

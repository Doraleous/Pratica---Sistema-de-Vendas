package com.pratica.sistemaDeVendas.view;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pratica.sistemaDeVendas.model.Usuario;
import com.pratica.sistemaDeVendas.model.UsuarioDAO;

public class teste {
    public static void main(String[] args) throws SQLException {
        UsuarioDAO user= new UsuarioDAO();
        ArrayList<Usuario> usuarios = user.listarUsuario();
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }
}


package com.pratica.sistemadevendas.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pratica.sistemadevendas.model.Administrador;
import com.pratica.sistemadevendas.model.Usuario;
import com.pratica.sistemadevendas.model.dao.UsuarioDAO;
import com.pratica.sistemadevendas.view.Aplicacao;

public class UsuarioController {
    private UsuarioDAO usuarioDAO;
    private Aplicacao aplicacao;
    
    public UsuarioController(){
        this.usuarioDAO = new UsuarioDAO();
        this.aplicacao = new Aplicacao();

    }

    public void cadastraAdministradorController(String CPF, String senha, String nome, String email) throws SQLException{
        if(this.usuarioDAO.usuarioExiste(email) == true){
            this.aplicacao.getTelaOperacoesUsuario().getLabelStatusOperacao().setText("Usuário já existe");

        }else{
            Usuario novoUsuario = new Usuario(CPF, senha, nome, email);
            this.usuarioDAO.cadastrarUsuario(novoUsuario);
            this.aplicacao.getTelaOperacoesUsuario().getLabelStatusOperacao().setText("Usuário cadastrado");
        }


    }

    

    

   


    
    
    

}

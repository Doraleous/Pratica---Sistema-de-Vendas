package com.pratica.sistemaDeVendas.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.pratica.sistemadevendas.model.Administrador;
import com.pratica.sistemadevendas.model.Usuario;
import com.pratica.sistemadevendas.model.dao.UsuarioDAO;
import com.pratica.sistemadevendas.view.Aplicacao;

public class UsuarioController {
    private UsuarioDAO usuarioDAO;
    private Aplicacao aplicacao;

    public UsuarioController(Aplicacao aplicacao) {
        this.usuarioDAO = new UsuarioDAO();
        this.aplicacao = aplicacao;

    }
    /*
     * )
     * && (this.aplicacao.getTelaLogin().campoLogin().contains("@"))
     * && (!this.aplicacao.getTelaLogin().equals(""))
     * && (this.usuarioDAO.usuarioExiste(email))
     */

    public String Logar(String email, String senha) throws SQLException {
        if ((this.aplicacao.getTelaLogin().campoLogin().equals(""))) {
            this.aplicacao.getTelaLogin().getLabelStatusOperacao().setText("Campo Login Vazio");
            return null;
        } else if (!this.aplicacao.getTelaLogin().campoLogin().contains("@")) {
            this.aplicacao.getTelaLogin().getLabelStatusOperacao().setText("Login necessita ter @");
            return null;

        } else if (!this.aplicacao.getTelaLogin().campoLogin().contains(".")) {
            this.aplicacao.getTelaLogin().getLabelStatusOperacao().setText("Login necessita ter .");
            return null;

        } else if (this.aplicacao.getTelaLogin().campoSenha().equals("")) {
            this.aplicacao.getTelaLogin().getLabelStatusOperacao().setText("Campo Senha Vazio");
            return null;

        } else if ((!this.usuarioDAO.usuarioExiste(email))) {
            this.aplicacao.getTelaLogin().getLabelStatusOperacao().setText("Usuário não existe");
            return null;

        } else if (!this.usuarioDAO.verificaSenha(email, senha)) {
            this.aplicacao.getTelaLogin().getLabelStatusOperacao().setText("Credenciais não conferem");
            return null;

        } else {
            long idUsuario = this.usuarioDAO.buscarUsuario(email);
            AdministradorController administradorController = new AdministradorController(this.aplicacao);
            if (administradorController.isAdministrador(idUsuario)) {
                return "Administrador";
            }
            UsuarioComumController usuarioComumController = new UsuarioComumController(this.aplicacao);
            if (usuarioComumController.isUsuarioComum(idUsuario)) {
                return "Usuário Comum";
            }

            return "true";

        }

    }

    public void cadastraAdministradorController(String CPF, String senha, String nome, String email,
            Date dataDeNascimento)
            throws SQLException {
        if (this.usuarioDAO.usuarioExiste(email) == true) {
            this.aplicacao.getTelaOperacoesUsuario().getLabelStatusOperacao().setText("Usuário já existe");

        } else {
            Usuario novoUsuario = new Usuario(CPF, senha, nome, email, dataDeNascimento);
            this.usuarioDAO.cadastrarUsuario(novoUsuario);
            this.aplicacao.getTelaOperacoesUsuario().getLabelStatusOperacao().setText("Usuário cadastrado");
        }


    }

    

    

   


    
    
    

}

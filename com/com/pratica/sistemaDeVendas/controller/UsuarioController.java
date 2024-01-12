package com.pratica.sistemaDeVendas.controller;

import java.sql.SQLException;
import java.util.Date;

import com.pratica.sistemaDeVendas.model.Usuario;
import com.pratica.sistemaDeVendas.model.dao.UsuarioDAO;
import com.pratica.sistemaDeVendas.view.Aplicacao;

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

     public String bemVindoNome(){
        return this.usuarioDAO.bemVindoNome(this.aplicacao.getTelaLogin().loginTextField().getText());
     }

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

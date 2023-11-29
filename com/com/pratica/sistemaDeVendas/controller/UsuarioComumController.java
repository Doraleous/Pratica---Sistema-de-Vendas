package com.pratica.sistemadevendas.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pratica.sistemadevendas.model.Filme;
import com.pratica.sistemadevendas.model.Usuario;
import com.pratica.sistemadevendas.model.UsuarioComum;
import com.pratica.sistemadevendas.model.dao.UsuarioComumDAO;
import com.pratica.sistemadevendas.model.dao.UsuarioDAO;
import com.pratica.sistemadevendas.view.Aplicacao;

public class UsuarioComumController {
    private Aplicacao aplicacao;
    private UsuarioComumDAO usuarioComumDAO;
    private UsuarioDAO usuarioDAO;

    public UsuarioComumController(Aplicacao aplicacao) {
        this.aplicacao = aplicacao;
        usuarioDAO = new UsuarioDAO();
        usuarioComumDAO = new UsuarioComumDAO();

    }

    public boolean isUsuarioComum(long idUsuario) throws SQLException {
        UsuarioComumDAO usuarioComumDAO = new UsuarioComumDAO();
        return usuarioComumDAO.isUsuarioComum(idUsuario);
    }

    public boolean controlaCadastroUsuarioComum() {
        if ((this.aplicacao.getTelaOperacoesUsuario().getEmailTextField().getText().trim().equals("") ||
                this.aplicacao.getTelaOperacoesUsuario().getEmailTextField().getText() == null)
                || (this.aplicacao.getTelaOperacoesUsuario().getnomeTextField().getText().trim().equals("") ||
                        this.aplicacao.getTelaOperacoesUsuario().getnomeTextField().getText() == null)
                || (this.aplicacao.getTelaOperacoesUsuario().getsenhaTextField().getText().trim().equals("") ||
                        this.aplicacao.getTelaOperacoesUsuario().getsenhaTextField().getText() == null)
                || (this.aplicacao.getTelaOperacoesUsuario().getcpTextField().getText().trim().equals("") ||
                        this.aplicacao.getTelaOperacoesUsuario().getcpTextField().getText() == null)) {
            this.aplicacao.getTelaOperacoesUsuario().getLabelStatusOperacao()
                    .setText("Todos os campos devem ser preenchidos");
            return false;

        } else if (!this.aplicacao.getTelaOperacoesUsuario().getEmailTextField().getText().contains("@")
                || (!this.aplicacao.getTelaOperacoesUsuario().getEmailTextField().getText().contains("."))) {
            this.aplicacao.getTelaOperacoesUsuario().getLabelStatusOperacao()
                    .setText("Email deve conter @ e .");

        } else {
            return true;
        }
        return false;
    }

<<<<<<< HEAD
    
    public void cadastraUsuarioComum(UsuarioComum novoUsuarioComum) {
=======
    // cpf senha nome email datanascimento //continuar depois, chamar o cadastro de
    // usuário comum e usuário
    public void cadastraUsuarioComum(UsuarioComum novoUsuarioComum) throws SQLException {
>>>>>>> 7ee781ac2227f93bde7bff53cdf54d667af9ad3b
        novoUsuarioComum = new UsuarioComum(this.aplicacao.getTelaOperacoesUsuario().getcpTextField().getText(),
                this.aplicacao.getTelaOperacoesUsuario().getsenhaTextField().getText(),
                this.aplicacao.getTelaOperacoesUsuario().getnomeTextField().getText(),
                this.aplicacao.getTelaOperacoesUsuario().getEmailTextField().getText(), null);
<<<<<<< HEAD
        if (this.aplicacao.getUsuarioComumController().controlaCadastroUsuarioComum() &&
                !this.aplicacao.getAdministradorController()
                        .usuarioExiste(this.aplicacao.getTelaOperacoesUsuario().getEmailTextField().getText())) {
                            
=======
        if (!this.aplicacao.getAdministradorController()
                .usuarioExiste(this.aplicacao.getTelaOperacoesUsuario().getEmailTextField().getText())) {
            // usuarioDAO.cadastrarUsuario(novoUsuarioComum);
            usuarioComumDAO.cadastrarUsuarioComum(novoUsuarioComum);
            this.aplicacao.getTelaOperacoesUsuario().getcpTextField().setText("");
            this.aplicacao.getTelaOperacoesUsuario().getsenhaTextField().setText("");
            this.aplicacao.getTelaOperacoesUsuario().getnomeTextField().setText("");
            this.aplicacao.getTelaOperacoesUsuario().getEmailTextField().setText("");
            this.aplicacao.getTelaOperacoesUsuario().getLabelStatusOperacao().setText("Usuário cadastrado com sucesso");
>>>>>>> 7ee781ac2227f93bde7bff53cdf54d667af9ad3b

        } else {
            this.aplicacao.getTelaOperacoesUsuario().getLabelStatusOperacao()
                    .setText("Usuário já existe");
        }

    }

}

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
    private AdministradorDAO administradorDAO;

    public AdministradorController(Aplicacao aplicacao) {
        this.aplicacao = aplicacao;
        administradorDAO = new AdministradorDAO();

    }

    public boolean isAdministrador(long idUsuario) throws SQLException {
        AdministradorDAO administradorDAO = new AdministradorDAO();
        return administradorDAO.isAdministrador(idUsuario);
    }

    public boolean cadastrarUsuario(String tipo) throws SQLException {
        switch (tipo) {
            case "Comum":
                UsuarioComumController usuarioComumController = new UsuarioComumController(this.aplicacao);
                if (usuarioComumController.controlaCadastroUsuarioComum()) {
                    UsuarioComum novoUsuarioComum = new UsuarioComum(
                            this.aplicacao.getTelaOperacoesUsuario().getcpTextField().getText(),
                            this.aplicacao.getTelaOperacoesUsuario().getsenhaTextField().getText(),
                            this.aplicacao.getTelaOperacoesUsuario().getnomeTextField().getText(),
                            this.aplicacao.getTelaOperacoesUsuario().getEmailTextField().getText(), null);
                    usuarioComumController.cadastraUsuarioComum(novoUsuarioComum);
                }

                break;
            case "Administrador":
                AdministradorController administradorController = new AdministradorController(this.aplicacao);
                if (administradorController.controlaCadastroAdministrador()) {
                    Administrador novoAdministrador = new Administrador(
                            this.aplicacao.getTelaOperacoesUsuario().getcpTextField().getText(),
                            this.aplicacao.getTelaOperacoesUsuario().getsenhaTextField().getText(),
                            this.aplicacao.getTelaOperacoesUsuario().getnomeTextField().getText(),
                            this.aplicacao.getTelaOperacoesUsuario().getEmailTextField().getText(), null);
                    administradorController.cadastraAdministrador(novoAdministrador);
                }

                break;
            case "Estudante":
                UsuarioEstudanteController usuarioEstudanteContoller = new UsuarioEstudanteController(this.aplicacao);

                if (usuarioEstudanteContoller.controlaCadastroEstudante()) {
                    UsuarioEstudante novoEstudante = new UsuarioEstudante(
                            this.aplicacao.getTelaOperacoesUsuario().getcpTextField().getText(),
                            this.aplicacao.getTelaOperacoesUsuario().getsenhaTextField().getText(),
                            this.aplicacao.getTelaOperacoesUsuario().getnomeTextField().getText(),
                            this.aplicacao.getTelaOperacoesUsuario().getEmailTextField().getText(),
                            null);
                    usuarioEstudanteContoller.cadastrarUsuarioEstudante(novoEstudante);
                }

                break;
            case "Crítico":

                break;

            default:
                return false;
        }
        return false;
    }

    public void cadastrarFilme(String titulo) throws SQLException {
        FilmeController filmeController = new FilmeController(this.aplicacao);
        filmeController.cadastraFilme();
    }

    public boolean usuarioExiste(String email) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.usuarioExiste(email);
    }

    public boolean controlaCadastroAdministrador() {
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

    public void cadastraAdministrador(Administrador administrador) throws SQLException {
        administrador = new Administrador(this.aplicacao.getTelaOperacoesUsuario().getcpTextField().getText(),
                this.aplicacao.getTelaOperacoesUsuario().getsenhaTextField().getText(),
                this.aplicacao.getTelaOperacoesUsuario().getnomeTextField().getText(),
                this.aplicacao.getTelaOperacoesUsuario().getEmailTextField().getText(), null);
        if (!this.aplicacao.getAdministradorController()
                .usuarioExiste(this.aplicacao.getTelaOperacoesUsuario().getEmailTextField().getText())) {
            // usuarioDAO.cadastrarUsuario(novoUsuarioComum);
            administradorDAO.cadastrarAdministrador(administrador);
            this.aplicacao.getTelaOperacoesUsuario().getcpTextField().setText("");
            this.aplicacao.getTelaOperacoesUsuario().getsenhaTextField().setText("");
            this.aplicacao.getTelaOperacoesUsuario().getnomeTextField().setText("");
            this.aplicacao.getTelaOperacoesUsuario().getEmailTextField().setText("");
            this.aplicacao.getTelaOperacoesUsuario().getLabelStatusOperacao().setText("Usuário cadastrado com sucesso");

        } else {
            this.aplicacao.getTelaOperacoesUsuario().getLabelStatusOperacao()
                    .setText("Usuário já existe");
        }
    }

}

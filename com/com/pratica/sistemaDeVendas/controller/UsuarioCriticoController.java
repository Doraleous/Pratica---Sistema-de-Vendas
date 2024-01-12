package com.pratica.sistemaDeVendas.controller;

import java.sql.SQLException;

import com.pratica.sistemaDeVendas.model.UsuarioCritico;
import com.pratica.sistemaDeVendas.model.dao.UsuarioCriticoDAO;
import com.pratica.sistemaDeVendas.view.Aplicacao;

public class UsuarioCriticoController {
    private Aplicacao aplicacao;
    private UsuarioCriticoDAO usuarioCriticoDAO;

    public UsuarioCriticoController(Aplicacao aplicacao) {
        this.aplicacao = aplicacao;
        usuarioCriticoDAO = new UsuarioCriticoDAO();
    }

    public boolean controlaCadastroCritico() {
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

    public void cadastrarUsuarioCritico(UsuarioCritico usuarioCritico) throws SQLException {
        usuarioCritico = new UsuarioCritico(this.aplicacao.getTelaOperacoesUsuario().getcpTextField().getText(),
                this.aplicacao.getTelaOperacoesUsuario().getsenhaTextField().getText(),
                this.aplicacao.getTelaOperacoesUsuario().getnomeTextField().getText(),
                this.aplicacao.getTelaOperacoesUsuario().getEmailTextField().getText(), null);
        if (!this.aplicacao.getAdministradorController()
                .usuarioExiste(this.aplicacao.getTelaOperacoesUsuario().getEmailTextField().getText())) {
            // usuarioDAO.cadastrarUsuario(novoUsuarioComum);
            usuarioCriticoDAO.cadastrarUsuarioCritico(usuarioCritico);
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

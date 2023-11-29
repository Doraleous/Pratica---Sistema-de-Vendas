package com.pratica.sistemadevendas.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pratica.sistemadevendas.model.Filme;
import com.pratica.sistemadevendas.model.Usuario;
import com.pratica.sistemadevendas.model.UsuarioComum;
import com.pratica.sistemadevendas.model.dao.UsuarioComumDAO;
import com.pratica.sistemadevendas.view.Aplicacao;

public class UsuarioComumController {
    private Aplicacao aplicacao;
    private UsuarioComumDAO usuarioComumDAO;

    public UsuarioComumController(Aplicacao aplicacao) {
        this.aplicacao = aplicacao;

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

    
    public void cadastraUsuarioComum(UsuarioComum novoUsuarioComum) {
        novoUsuarioComum = new UsuarioComum(this.aplicacao.getTelaOperacoesUsuario().getcpTextField().getText(),
                this.aplicacao.getTelaOperacoesUsuario().getsenhaTextField().getText(),
                this.aplicacao.getTelaOperacoesUsuario().getnomeTextField().getText(),
                this.aplicacao.getTelaOperacoesUsuario().getEmailTextField().getText(), null);
        if (this.aplicacao.getUsuarioComumController().controlaCadastroUsuarioComum() &&
                !this.aplicacao.getAdministradorController()
                        .usuarioExiste(this.aplicacao.getTelaOperacoesUsuario().getEmailTextField().getText())) {
                            

        }

    }

}

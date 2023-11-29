/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pratica.sistemadevendas.view;

import java.io.IOException;
import java.sql.SQLException;

import com.pratica.sistemadevendas.controller.AdministradorController;
import com.pratica.sistemadevendas.controller.UsuarioComumController;
import com.pratica.sistemadevendas.controller.UsuarioController;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Aplicacao extends Application {
    private Stage estagioAtual;
    private TelaAdministrador telaAdministrador;
    private TelaLogin telaLogin;
    private TelaOperacoesUsuario telaOperacoesUsuario2;
    private UsuarioController usuarioController;
    private TelaOperacoesLanchonete telaOperacoesLanchonete;
    private TelaOperacoesFilmesCLUD telaOperacoesFilmesCLUD;
    private TelaOperacoesSala telaOperacoesSala;
    private TelaOperacoesSessao telaOperacoeSessao;
    private TelaUsuario telaUsuario;
    private TelaComprarFilmes telaComprarFilmes;
    private UsuarioComumController usuarioComumController;
    private AdministradorController administradorController;

    private TelaOperacoesFilme telaOperacoesFilme;

    public static void main(String[] args) {
        Application.launch(args);

    }

    public void start(Stage estagioPrimario) throws IOException, SQLException {

        estagioAtual = new Stage();

        estagioAtual = new Stage();
        estagioAtual.initStyle(StageStyle.UNDECORATED);
        estagioAtual.setTitle("Cinecap - Logar Usuário");
        estagioAtual.setWidth(800);
        estagioAtual.setHeight(800);

        telaAdministrador = new TelaAdministrador(this);
        telaLogin = new TelaLogin(this);
        telaOperacoesUsuario2 = new TelaOperacoesUsuario(this);
        telaOperacoesLanchonete = new TelaOperacoesLanchonete(this);
        telaOperacoesFilme = new TelaOperacoesFilme(this);
        telaOperacoesFilmesCLUD = new TelaOperacoesFilmesCLUD(this);
        telaOperacoesSala = new TelaOperacoesSala(this);
        telaOperacoeSessao = new TelaOperacoesSessao(this);
        telaUsuario = new TelaUsuario(this);
        telaComprarFilmes = new TelaComprarFilmes(this);
        usuarioComumController = new UsuarioComumController(this);
        administradorController = new AdministradorController(this);

        usuarioController = new UsuarioController(this);

        estagioAtual.setScene(this.telaLogin.telaLogin());
        estagioAtual.show();

    }

    public TelaAdministrador getTelaAdministrador() {
        return this.telaAdministrador;
    }

    public TelaLogin getTelaLogin() {
        return this.telaLogin;
    }

    public TelaOperacoesUsuario getTelaOperacoesUsuario() {
        return this.telaOperacoesUsuario2;

    }

    public TelaOperacoesLanchonete getTelaOperacoesLanchonete() {
        return this.telaOperacoesLanchonete;
    }

    public TelaOperacoesFilme getTelaOperacoesFilme() {
        return this.telaOperacoesFilme;
    }

    public TelaOperacoesFilmesCLUD getTelaOperacoesFilmesCLUD() {
        return this.telaOperacoesFilmesCLUD;
    }

    public TelaOperacoesSala gettTelaOperacoesSala() {
        return this.telaOperacoesSala;
    }

    public TelaOperacoesSessao getTelaOperacoesSessao() {
        return this.telaOperacoeSessao;
    }

    public TelaUsuario getTelaUsuario() {
        return this.telaUsuario;
    }

    public TelaComprarFilmes getTelaComprarFilmes() {
        return this.telaComprarFilmes;
    }

    public UsuarioController getUsuarioController() {
        return this.usuarioController;
    }

    public UsuarioComumController getUsuarioComumController() {
        return this.usuarioComumController;
    }

    public AdministradorController getAdministradorController() {
        return this.administradorController;
    }

    public void mudaCena(Scene novaCena) {
        this.estagioAtual.setScene(novaCena);
        this.estagioAtual.show();

    }

    public Stage estagioAtual() {
        return this.estagioAtual;
    }

}

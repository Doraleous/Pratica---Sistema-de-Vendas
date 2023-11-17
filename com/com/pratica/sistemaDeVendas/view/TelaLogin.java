/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pratica.sistemaDeVendas.view;

import com.pratica.sistemaDeVendas.controller.UsuarioController;
import com.pratica.sistemaDeVendas.model.Usuario;
import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author emart
 */
public class TelaLogin {

    private TextField loginTextField;
    private TextField senhaTextField;

    private Label loginLabel;
    private Label senhaLabel;
    private Label labelTitulo;

    private Button loginBotao;
    private Button sairBotao;

    

    private Aplicacao aplicacao;

    private UsuarioController usuarioController;

    public TelaLogin(Aplicacao aplicacao) {
        this.loginTextField = new TextField();
        loginTextField.setPrefWidth(400);

        this.senhaTextField = new TextField();
        senhaTextField.setPrefWidth(400);
        this.labelTitulo = new Label("CineCap");
        labelTitulo.setStyle("-fx-text-fill: white; -fx-font-size: 24px;");

        this.loginLabel = new Label("Email:");
        this.senhaLabel = new Label("Senha: ");

        this.loginBotao = new Button("Login");
        this.sairBotao = new Button("Sair");

        

        this.aplicacao = aplicacao;

        this.usuarioController = new UsuarioController();

        loginBotao.setOnAction(e -> acaoDeLogar());
        sairBotao.setOnAction(e -> sair());
    }

    public void sair() {
        this.usuarioController.sair();
        this.aplicacao.estagioAtual().close();
    }

    public void acaoDeLogar() {

        if (usuarioController.login(loginTextField.getText(), senhaTextField.getText()) == true) {
            if (usuarioController.buscarUsuario(loginTextField.getText()) instanceof Usuario) {
                //TelaAdministrador telaADM = new TelaAdministrador(aplicacao);
                //Scene cenaADM = telaADM.telaMenuAdministrador();
                this.aplicacao.mudaCena(this.aplicacao.getTelaAdministrador().telaMenuAdministrador());
            }
        } else {
            System.out.println("A senha tá errada");
        }

    }

    public Scene telaLogin() {
        GridPane paneLogin = new GridPane();
        paneLogin.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        paneLogin.setHgap(5.5);
        paneLogin.setVgap(5.5);
        paneLogin.setStyle("-fx-background-color: red;");

        paneLogin.add(labelTitulo, 0, 0);
        paneLogin.add(loginLabel, 0, 1);
        paneLogin.add(loginTextField, 1, 1);
        paneLogin.add(senhaLabel, 0, 2);
        paneLogin.add(senhaTextField, 1, 2);
        paneLogin.add(loginBotao, 0, 3);
        paneLogin.add(sairBotao, 0, 4);

        Scene cenaLogin = new Scene(paneLogin, 600, 350);
        return cenaLogin;

    }

}

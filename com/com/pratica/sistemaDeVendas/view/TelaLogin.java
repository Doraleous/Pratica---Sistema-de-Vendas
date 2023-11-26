/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pratica.sistemaDeVendas.view;

import com.pratica.sistemaDeVendas.controller.UsuarioController;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

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

    private VBox telaLogin;

    private Scene cenaLogin;

    

    private Aplicacao aplicacao;

    private UsuarioController usuarioController;

    public TelaLogin(Aplicacao aplicacao) {
        this.loginTextField = new TextField();
        loginTextField.setPrefWidth(300);
        loginTextField.setMaxWidth(400);
        loginTextField.setStyle("-fx-border-color: black; -fx-border-width: 2px;");

        this.senhaTextField = new TextField();
        senhaTextField.setPrefWidth(300);
        senhaTextField.setMaxWidth(400);
        senhaTextField.setStyle("-fx-border-color: black; -fx-border-width: 2px;");

        this.labelTitulo = new Label("CineCap");
        labelTitulo.setStyle("-fx-text-fill: white; -fx-font-size: 42px;");

        this.loginLabel = new Label("Email:");
        loginLabel.setStyle("-fx-text-fill: black; -fx-font-size: 20px;");
        this.senhaLabel = new Label("Senha: ");
        senhaLabel.setStyle("-fx-text-fill: black; -fx-font-size: 20px;");

        this.loginBotao = new Button("Login");
        this.sairBotao = new Button("Sair");

        telaLogin = new VBox();
        telaLogin.setSpacing(50);
        telaLogin.setStyle("-fx-background-color: red;");
        

        

        this.aplicacao = aplicacao;

        

        loginBotao.setOnAction(e -> acaoDeLogar());
        sairBotao.setOnAction(e -> sair());

        telaLogin.getChildren().addAll(labelTitulo, loginLabel, loginTextField, senhaLabel, senhaTextField,
        loginBotao, sairBotao);
        telaLogin.setAlignment(Pos.CENTER);

        cenaLogin = new Scene(telaLogin);
    }

    public void sair() {
        //this.usuarioController.sair();
        this.aplicacao.estagioAtual().close();
    }

    public void acaoDeLogar() {

        
        if(this.loginTextField.getText().equals("admin@cinecap.com") && this.senhaTextField.getText().equals("admin")){
            this.aplicacao.mudaCena(this.aplicacao.getTelaAdministrador().telaMenuAdministrador());
        }else{
            
        }

    }

    public Scene telaLogin() {
        
        return cenaLogin;

    }

}

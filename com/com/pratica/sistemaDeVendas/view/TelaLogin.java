/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pratica.sistemadevendas.view;

import java.sql.SQLException;

import com.pratica.sistemadevendas.controller.UsuarioController;

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
    private Label labelStatusOperacao;

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

        this.labelStatusOperacao = new Label("");
        labelStatusOperacao.setStyle("-fx-text-fill: yellow; -fx-font-size: 20px;");

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

        loginBotao.setOnAction(e -> {
            try {
                acaoDeLogar();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        sairBotao.setOnAction(e -> sair());

        telaLogin.getChildren().addAll(labelTitulo, loginLabel, loginTextField, senhaLabel, senhaTextField,
                loginBotao, sairBotao, labelStatusOperacao);
        telaLogin.setAlignment(Pos.CENTER);

        cenaLogin = new Scene(telaLogin);
    }

    public void sair() {
        // this.usuarioController.sair();
        this.aplicacao.estagioAtual().close();
    }

    public String campoSenha() {
        return this.senhaTextField.getText();
    }

    public String campoLogin() {
        return this.loginTextField.getText();
    }

    public Label getLabelStatusOperacao() {
        return this.labelStatusOperacao;
    }

    public void acaoDeLogar() throws SQLException {
        String email = this.campoLogin();
        String senha = this.campoSenha();
        String tipoDeUsuario = this.aplicacao.getUsuarioController().Logar(email, senha);

        switch (tipoDeUsuario) {
            case "Administrador":
                this.aplicacao.mudaCena(this.aplicacao.getTelaAdministrador().telaMenuAdministrador());
                break;

            case "Usuário Comum":
                break;

            case "Usuário Crítico":
                break;

            case "Usuário Estudante":
                break;

            default:
                break;
        }
        /*
         * if(this.aplicacao.getUsuarioController().Logar(email, senha)){
         * this.aplicacao.mudaCena(this.aplicacao.getTelaAdministrador().
         * telaMenuAdministrador());
         * 
         * }
         */

    }

    public Scene telaLogin() {

        return cenaLogin;

    }

}

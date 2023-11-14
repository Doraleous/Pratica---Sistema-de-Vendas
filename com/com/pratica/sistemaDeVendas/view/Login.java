package com.pratica.sistemaDeVendas.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Login extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("CineCap - Tela de Login");

        // Criar elementos da interface
        Label labelTitulo = new Label("CineCap");
        labelTitulo.setStyle("-fx-text-fill: white; -fx-font-size: 24px;");

        Label labelEmail = new Label("Email");
        labelEmail.setStyle("-fx-text-fill: black;");

        TextField textFieldEmail = new TextField();

        Label labelSenha = new Label("Senha");
        labelSenha.setStyle("-fx-text-fill: black;");

        PasswordField passwordFieldSenha = new PasswordField();

        Button btnEntrar = new Button("Entrar");
        btnEntrar.setStyle("-fx-text-fill: black; -fx-background-color: white;");

        // Layout
        VBox layout = new VBox(10);
        layout.setStyle("-fx-background-color: #FFD700; -fx-padding: 20px;");
        layout.getChildren().addAll(labelTitulo, labelEmail, textFieldEmail, labelSenha, passwordFieldSenha, btnEntrar);

        // Cena
        Scene scene = new Scene(layout, 300, 250, Color.RED);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}


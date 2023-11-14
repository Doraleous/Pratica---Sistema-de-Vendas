package com.pratica.sistemaDeVendas.view;

import com.pratica.sistemaDeVendas.controller.UsuarioController;

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

    private VBox layout;

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
        btnEntrar.setOnAction(event ->{
            String email = textFieldEmail.getText();
            String senha = passwordFieldSenha.getText();
            String situacaoDados = validaDados(email);

            if(!situacaoDados.equals("ok")){
                Label labelErro = new Label(situacaoDados);
                labelErro.setStyle("-fx-text-fill: red;");
                layout.getChildren().add(labelErro);
            }else{
                UsuarioController usuarioController = new UsuarioController();
                boolean loginSucesso = usuarioController.login(email, senha);

                if(!loginSucesso){
                    Label labelErro = new Label("Erro: Login falhou!");
                    labelErro.setStyle("-fx-text-fill: red;");
                    layout.getChildren().add(labelErro);
                }
            }
        });

        // Layout
        layout = new VBox(10);
        layout.setStyle("-fx-background-color: #FFD700; -fx-padding: 20px;");
        layout.getChildren().addAll(labelTitulo, labelEmail, textFieldEmail, labelSenha, passwordFieldSenha, btnEntrar);

        // Cena
        Scene scene = new Scene(layout, 300, 250, Color.RED);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /**
     * @return VBox return the layout
     */
    public VBox getLayout() {
        return layout;
    }

    /**
     * @param layout the layout to set
     */
    public void setLayout(VBox layout) {
        this.layout = layout;
    }

    public String validaDados(String email){
        if(email.equalsIgnoreCase("")){
            return "E-mail em branco";
        }
        if(!email.contains("@") && !email.contains(".")){
            return "E-mail inválido";
        }
        return "ok";
    }

}


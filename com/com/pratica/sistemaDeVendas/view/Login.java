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
import javafx.stage.StageStyle;

public class Login extends Application {

    private VBox layout;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.initStyle(StageStyle.UNDECORATED);
        //primaryStage.setTitle("CineCap - Tela de Login");
        UsuarioController usuarioController = new UsuarioController();

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
            String situacaoDados = validaDados(email,senha);
            if(!situacaoDados.equals("ok")){
                if(layout.getChildren().size() <=7){
                    Label labelErro = new Label(situacaoDados);
                    labelErro.setStyle("-fx-text-fill: black;");
                    layout.getChildren().add(labelErro);
                }else{
                    layout.getChildren().remove(7);
                    Label labelErro = new Label(situacaoDados);
                    labelErro.setStyle("-fx-text-fill: black;");
                    layout.getChildren().add(labelErro);
                }

            }else{
                boolean loginSucesso = usuarioController.login(email, senha);

                if(!loginSucesso){
                    if(layout.getChildren().size() <=7){
                        Label labelErro = new Label("Erro: Login falhou!");
                        labelErro.setStyle("-fx-text-fill: black;");
                        layout.getChildren().add(labelErro);
                    }else{
                        layout.getChildren().remove(7);
                        Label labelErro = new Label("Erro: Login falhou!");
                        labelErro.setStyle("-fx-text-fill: black;");
                        layout.getChildren().add(labelErro);
                    }
                }else{
                    Label labelErro = new Label("sucesso: Login deu certo!");
                    labelErro.setStyle("-fx-text-fill: black;");
                    layout.getChildren().add(labelErro);
                }
            }
        });

        Button btnSair = new Button("Sair");
        btnSair.setStyle("-fx-text-fill: black; -fx-background-color: white;");
        btnSair.setOnAction(event -> {
            usuarioController.sair();
            primaryStage.close();
        });

        // Layout
        layout = new VBox(10);
        layout.setStyle("-fx-background-color: #FF0000; -fx-padding: 20px;");
        layout.getChildren().addAll(labelTitulo, labelEmail, textFieldEmail, labelSenha, passwordFieldSenha, btnEntrar ,btnSair);

        // Cena
        Scene scene = new Scene(layout, 300, 350, Color.RED);

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

    public String validaDados(String email, String senha){
        if(email.equalsIgnoreCase("")){
            return "E-mail em branco";
        }
        if(senha.equalsIgnoreCase("")){
            return "Senha em branco";
        }
        if(!email.contains("@") && !email.contains(".")){
            return "E-mail inválido";
        }
        return "ok";
    }

}


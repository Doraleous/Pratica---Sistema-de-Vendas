package com.pratica.sistemaDeVendas.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TelaOperacoesUsuario {
    private Label labelCPF = new Label("CPF");
    private Label labelSenha = new Label("Senha");
    private Label labelNome = new Label("Nome");
    private Label labelEmail = new Label("Email");
    private Button botaoCadastrar = new Button("Cadastrar");
    private Button botaoDeletar = new Button("Deletar");
    private Button botaoBuscar = new Button("Buscar");
    private TextField textFieldCPF = new TextField();
    private TextField textFieldSenha = new TextField();
    private TextField textFieldNome = new TextField();
    private TextField textFieldEmail = new TextField();

    private Aplicacao aplicacao;

    public TelaOperacoesUsuario(Aplicacao aplicacao){
        this.aplicacao = aplicacao;

    }

    public Scene telaOperaCoesUsuario(){
        VBox caixaLabelsBotoes = new VBox(10);

       
        labelCPF.setPrefHeight(50);
        labelCPF.setPrefWidth(100);
        
        labelSenha.setPrefHeight(50);
        labelSenha.setPrefWidth(100);
        
        labelNome.setPrefHeight(50);
        labelNome.setPrefWidth(100);
       
        labelEmail.setPrefHeight(50);
        labelEmail.setPrefWidth(100);

        
        botaoCadastrar.setPrefWidth(100);
        
        botaoDeletar.setPrefWidth(100);
        
        botaoBuscar.setPrefWidth(100);

        caixaLabelsBotoes.setPadding(new Insets(10.5, 2, 10.5, 2));
        

        caixaLabelsBotoes.getChildren().addAll(labelCPF, labelSenha, 
        labelNome, labelEmail, botaoCadastrar, botaoDeletar, botaoBuscar);
       
        VBox caixaTextFields = new VBox(10);

        
        textFieldCPF.setPrefWidth(300);
        textFieldCPF.setPrefHeight(50);
        
        textFieldSenha.setPrefWidth(300);

        textFieldSenha.setPrefHeight(50);
        
        textFieldNome.setPrefWidth(300);
        textFieldNome.setPrefHeight(50);
        
        textFieldEmail.setPrefHeight(50);
        textFieldEmail.setPrefWidth(300);

        caixaTextFields.setPadding(new Insets(10.5, 2, 10.5, 2));

        caixaTextFields.getChildren().addAll(textFieldCPF, textFieldEmail, textFieldNome, textFieldSenha);

        HBox caixaConteiner = new HBox();
        caixaConteiner.setStyle("-fx-background-color: red;");

        caixaConteiner.getChildren().addAll(caixaLabelsBotoes, caixaTextFields); 

        Scene cenaOperacoesUsuario = new Scene(caixaConteiner);

        return cenaOperacoesUsuario;
    }
    
}

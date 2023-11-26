package com.pratica.sistemaDeVendas.view;

import com.pratica.sistemaDeVendas.controller.UsuarioController;
import com.pratica.sistemaDeVendas.model.Administrador;
import com.pratica.sistemaDeVendas.model.UsuarioComum;
import com.pratica.sistemaDeVendas.model.UsuarioCritico;
import com.pratica.sistemaDeVendas.model.UsuarioEstudante;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Stage;

public class TelaOperacoesUsuario {

    

    private UsuarioController usuarioController = new UsuarioController();
    private Label labelCPF = new Label("CPF");
    private Label labelSenha = new Label("Senha");
    private Label labelNome = new Label("Nome");
    private Label labelEmail = new Label("Email");
    private Button botaoCadastrarADM = new Button("Cadastrar Admin");
    private Button botaoCadastrarCritico = new Button("Cadastrar Crítico");
    private Button botaoCadastrarUsuarioComum = new Button("Cadastrar Cliente");
    private Button botaoCadastrarEstudante = new Button("Cadastrar Estudante");
    private Button botaoSair = new Button ("Voltar");
    private Button botaoDeletar = new Button("Deletar");
    private Button botaoBuscar = new Button("Buscar");
    private TextField textFieldCPF = new TextField();
    private TextField textFieldSenha = new TextField();
    private TextField textFieldNome = new TextField();
    private TextField textFieldEmail = new TextField();
    private VBox caixaTextFields = new VBox(10);
    private HBox caixaConteiner = new HBox();
    private Stage estagioAtual = new Stage();
    private Label labelStatusOperacao = new Label("Status");
    private VBox caixaLabelsBotoes = new VBox(10);
    private Scene cenaOperacoesUsuario;

    private Aplicacao aplicacao;

    public TelaOperacoesUsuario(Aplicacao aplicacao){
        this.aplicacao = aplicacao;

        

        
        
        labelCPF.setPrefHeight(50);
        labelCPF.setPrefWidth(100);
        
        labelSenha.setPrefHeight(50);
        labelSenha.setPrefWidth(100);
        
        labelNome.setPrefHeight(50);
        labelNome.setPrefWidth(100);
        
        
        labelEmail.setPrefHeight(50);
        labelEmail.setPrefWidth(100);

        
        
        
        botaoSair.setPrefWidth(100);

        
        botaoSair.setOnAction(e -> sair());

        
        
        botaoSair.setPrefWidth(100);

        
        botaoSair.setOnAction(e -> sair());

        
        botaoDeletar.setPrefWidth(100);
        
        botaoBuscar.setPrefWidth(100);
        labelStatusOperacao.setPrefWidth(100);

        caixaLabelsBotoes.setPadding(new Insets(10.5, 2, 10.5, 2));
        

        caixaLabelsBotoes.getChildren().addAll(labelCPF, labelSenha, 
        labelNome, labelEmail, botaoDeletar, botaoBuscar, botaoSair, labelStatusOperacao);
       
        
        

        
        textFieldCPF.setPrefWidth(300);
        textFieldCPF.setPrefHeight(50);
        
        textFieldSenha.setPrefWidth(300);
        textFieldSenha.setPrefHeight(50);
        
        textFieldNome.setPrefWidth(300);
        textFieldNome.setPrefHeight(50);
        
        textFieldEmail.setPrefHeight(50);
        textFieldEmail.setPrefWidth(300);

       
        botaoCadastrarADM.setPrefWidth(200);
        
        botaoCadastrarCritico.setPrefWidth(200);
       
        botaoCadastrarUsuarioComum.setPrefWidth(200);
        
        botaoCadastrarEstudante.setPrefWidth(200);

        caixaTextFields.setPadding(new Insets(10.5, 2, 10.5, 2));

        caixaTextFields.getChildren().addAll(textFieldCPF, textFieldEmail, textFieldNome, textFieldSenha,
        botaoCadastrarADM, botaoCadastrarCritico, botaoCadastrarUsuarioComum, botaoCadastrarEstudante);

        
        

        
        caixaConteiner.setStyle("-fx-background-color: red;");

        caixaConteiner.getChildren().addAll(caixaLabelsBotoes, caixaTextFields);

        cenaOperacoesUsuario = new Scene(caixaConteiner);

    }

    public Scene telaOperaCoesUsuario(){
        
        
        

        return cenaOperacoesUsuario;
        
    }

    


    public void sair(){
        this.aplicacao.mudaCena(this.aplicacao.getTelaAdministrador().telaMenuAdministrador());

    }
    
}

package com.pratica.sistemadevendas.view;

import com.pratica.sistemadevendas.controller.UsuarioController;
import com.pratica.sistemadevendas.model.Administrador;
import com.pratica.sistemadevendas.model.UsuarioComum;
import com.pratica.sistemadevendas.model.UsuarioCritico;
import com.pratica.sistemadevendas.model.UsuarioEstudante;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
    private Button botaoSair = new Button ("Sair");
    private Button botaoDeletar = new Button("Deletar");
    private Button botaoBuscar = new Button("Buscar");
    private TextField textFieldCPF = new TextField();
    private TextField textFieldSenha = new TextField();
    private TextField textFieldNome = new TextField();
    private TextField textFieldEmail = new TextField();
    private VBox caixaTextFields = new VBox(10);
    private HBox caixaConteiner = new HBox();
    private Stage estagioAtual = new Stage();

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

        
        
        
        botaoSair.setPrefWidth(100);

        
        botaoSair.setOnAction(e -> sair());

        
        botaoDeletar.setPrefWidth(100);
        
        botaoBuscar.setPrefWidth(100);

        caixaLabelsBotoes.setPadding(new Insets(10.5, 2, 10.5, 2));
        

        caixaLabelsBotoes.getChildren().addAll(labelCPF, labelSenha, 
        labelNome, labelEmail, botaoDeletar, botaoBuscar, botaoSair);
       
        

        
        textFieldCPF.setPrefWidth(300);
        textFieldCPF.setPrefHeight(50);
        
        textFieldSenha.setPrefWidth(300);
        textFieldSenha.setPrefHeight(50);
        
        textFieldNome.setPrefWidth(300);
        textFieldNome.setPrefHeight(50);
        
        textFieldEmail.setPrefHeight(50);
        textFieldEmail.setPrefWidth(300);

        botaoCadastrarADM.setOnAction(e -> cadastraADM());
        botaoCadastrarCritico.setOnAction(e -> cadastraCritico());
        botaoCadastrarUsuarioComum.setOnAction(e -> cadastraUsuarioComum());
        botaoCadastrarEstudante.setOnAction(e -> cadastraEstudante());
        botaoCadastrarADM.setPrefWidth(200);
        
        botaoCadastrarCritico.setPrefWidth(200);
       
        botaoCadastrarUsuarioComum.setPrefWidth(200);
        
        botaoCadastrarEstudante.setPrefWidth(200);

        caixaTextFields.setPadding(new Insets(10.5, 2, 10.5, 2));

        caixaTextFields.getChildren().addAll(textFieldCPF, textFieldEmail, textFieldNome, textFieldSenha,
        botaoCadastrarADM, botaoCadastrarCritico, botaoCadastrarUsuarioComum, botaoCadastrarEstudante);

        
        caixaConteiner.setStyle("-fx-background-color: red;");

        caixaConteiner.getChildren().addAll(caixaLabelsBotoes, caixaTextFields);
        
        Scene cenaOperacoesUsuario = new Scene(caixaConteiner);

        return cenaOperacoesUsuario;
        
    }

    public void cadastraADM(){
        Administrador novoADM = new Administrador(this.textFieldCPF.getText(), this.textFieldSenha.getText(), 
        this.textFieldNome.getText(), this.textFieldEmail.getText());
        //this.usuarioController.addUsuarioTipo(novoADM);
        System.out.println("fui clicado botaoadm");
        //this.usuarioController.imprimeUsuarios();

    }

    public void cadastraCritico(){
        UsuarioCritico novoCritico = new UsuarioCritico(this.textFieldCPF.getText(), this.textFieldSenha.getText(), 
        this.textFieldNome.getText(), this.textFieldEmail.getText());
        //this.usuarioController.addUsuarioTipo(novoCritico);

    }

    public void cadastraEstudante(){
        UsuarioEstudante novoEstudante = new UsuarioEstudante(this.textFieldCPF.getText(), this.textFieldSenha.getText(), 
        this.textFieldNome.getText(), this.textFieldEmail.getText());
        //this.usuarioController.addUsuarioTipo(novoEstudante);

    }
    public void cadastraUsuarioComum(){
        UsuarioComum novoUsuarioComum = new UsuarioComum(this.textFieldCPF.getText(), this.textFieldSenha.getText(), 
        this.textFieldNome.getText(), this.textFieldEmail.getText());
        //this.usuarioController.addUsuarioTipo(novoUsuarioComum);

    }

    public void sair(){
        this.usuarioController.sair();
        this.aplicacao.estagioAtual().close();

    }
    
}

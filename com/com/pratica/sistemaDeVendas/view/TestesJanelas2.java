package com.pratica.sistemadevendas.view;

import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TestesJanelas2 extends Application {
    private Label labelNomeFilmeCLUD;
    private Button botaoCadastrarFilme;
    private Button botaoListarFilme;
    private Button botaoAtualizarFilme;
    private Button botaoDeletarFilme;
    private Button botaoVoltar;

    private TextField textFieldFilmeCLUD;

    private Label labelNomeFilmeAdicionarSessao;
    private TextField textFieldNomeFilmeAdicionarSessao;
    private Label labelSessaoAdicionada;
    private TextField textFieldSessaoAdicionada;
    private Button botaoAdicionarSessao;

    private VBox caixaLabelsBotoesFilmeCLUD;
    private VBox caixaTextFieldFilmeCLUD;
    private VBox caixaLabelBotaoSessoesCLUD;
    private VBox caixaTextFieldsSessaoCLUD;
    private HBox caixaConteiner;

    private Scene telaOperacoesFilme;

    

    public TestesJanelas2(){
        labelNomeFilmeCLUD = new Label("Nome Filme");
        labelNomeFilmeCLUD.setPrefHeight(50);
        labelNomeFilmeCLUD.setPrefWidth(100);

        botaoCadastrarFilme = new Button("Cadastrar Filme");
        botaoCadastrarFilme.setPrefWidth(200);
        botaoListarFilme = new Button("Listar Filme");
        botaoListarFilme.setPrefWidth(200);
        botaoAtualizarFilme = new Button("Atualizar Filme");
        botaoAtualizarFilme.setPrefWidth(200);
        botaoDeletarFilme = new Button("Deletar Filme");
        botaoDeletarFilme.setPrefWidth(200);
        botaoVoltar = new Button("Voltar");
        botaoVoltar.setPrefWidth(100);

        caixaLabelsBotoesFilmeCLUD = new VBox();
        caixaLabelsBotoesFilmeCLUD.getChildren().addAll(labelNomeFilmeCLUD, botaoCadastrarFilme,
        botaoListarFilme, botaoAtualizarFilme, botaoDeletarFilme, botaoVoltar);

        textFieldFilmeCLUD = new TextField();
        textFieldFilmeCLUD.setPrefWidth(300);
        textFieldFilmeCLUD.setPrefHeight(50);
        
        caixaTextFieldFilmeCLUD = new VBox();
        caixaTextFieldFilmeCLUD.setPadding(new Insets(10.5, 2, 10.5, 2));
        caixaTextFieldFilmeCLUD.getChildren().addAll(textFieldFilmeCLUD);

        labelNomeFilmeAdicionarSessao = new Label("Nome Filme");
        labelNomeFilmeAdicionarSessao.setPrefHeight(50);
        labelNomeFilmeAdicionarSessao.setPrefWidth(100);

        textFieldNomeFilmeAdicionarSessao = new TextField();
        textFieldNomeFilmeAdicionarSessao.setPrefWidth(300);
        textFieldNomeFilmeAdicionarSessao.setPrefHeight(50);
        labelSessaoAdicionada = new Label("Nova Sessão");
        labelSessaoAdicionada.setPrefHeight(50);
        labelSessaoAdicionada.setPrefWidth(100);

        textFieldSessaoAdicionada = new TextField();
        textFieldSessaoAdicionada.setPrefWidth(300);
        textFieldSessaoAdicionada.setPrefHeight(50);
        botaoAdicionarSessao = new Button("Cadastrar Sessão");
        botaoAdicionarSessao.setPrefWidth(200);

        caixaLabelBotaoSessoesCLUD = new VBox();
        caixaLabelBotaoSessoesCLUD.getChildren().addAll(labelNomeFilmeAdicionarSessao, labelSessaoAdicionada, botaoAdicionarSessao);

        caixaTextFieldsSessaoCLUD = new VBox();
        caixaTextFieldsSessaoCLUD.setPadding(new Insets(10.5, 2, 10.5, 2));
        caixaTextFieldsSessaoCLUD.getChildren().addAll(textFieldNomeFilmeAdicionarSessao, textFieldSessaoAdicionada);

        caixaConteiner = new HBox();
        caixaConteiner.setStyle("-fx-background-color: red;");
        caixaConteiner.getChildren().addAll(caixaLabelsBotoesFilmeCLUD, caixaTextFieldFilmeCLUD, caixaLabelBotaoSessoesCLUD, caixaTextFieldsSessaoCLUD);

        telaOperacoesFilme = new Scene(caixaConteiner);
    }

    public void start(Stage estagioPrimario) throws IOException{
        estagioPrimario.setScene(telaOperacoesFilme);
        estagioPrimario.show();

    }

    public Scene telaOperacoesFilme(){
        return telaOperacoesFilme;

    }

    

    public static void main(String[] args) {
        Application.launch(args);

    }
    

}
package com.pratica.sistemaDeVendas.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TelaOperacoesFilme {

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

    private Aplicacao aplicacao;

    public TelaOperacoesFilme(Aplicacao aplicacao){
        this.aplicacao = aplicacao;

        labelNomeFilmeCLUD = new Label("Nome Filme");
        labelNomeFilmeCLUD.setPrefHeight(50);
        labelNomeFilmeCLUD.setPrefWidth(100);

        botaoCadastrarFilme = new Button("Cadastrar Filme");
        botaoCadastrarFilme.setPrefWidth(300);
        botaoListarFilme = new Button("Listar Filme");
        botaoListarFilme.setPrefWidth(300);
        botaoAtualizarFilme = new Button("Atualizar Filme");
        botaoAtualizarFilme.setPrefWidth(300);
        botaoDeletarFilme = new Button("Deletar Filme");
        botaoDeletarFilme.setPrefWidth(300);
        botaoVoltar = new Button("Voltar");
        botaoVoltar.setPrefWidth(100);

        botaoVoltar.setOnAction(e -> voltar());

        caixaLabelsBotoesFilmeCLUD = new VBox();
        caixaLabelsBotoesFilmeCLUD.getChildren().addAll(labelNomeFilmeCLUD, botaoCadastrarFilme,
        botaoListarFilme, botaoAtualizarFilme, botaoDeletarFilme, botaoVoltar);

        textFieldFilmeCLUD = new TextField();
        textFieldFilmeCLUD.setPrefWidth(300);
        textFieldFilmeCLUD.setPrefHeight(30);
        
        caixaTextFieldFilmeCLUD = new VBox();
        caixaTextFieldFilmeCLUD.setPadding(new Insets(10.5, 2, 10.5, 2));
        caixaTextFieldFilmeCLUD.getChildren().addAll(textFieldFilmeCLUD);

        labelNomeFilmeAdicionarSessao = new Label("Nome Filme");
        labelNomeFilmeAdicionarSessao.setPrefHeight(50);
        labelNomeFilmeAdicionarSessao.setPrefWidth(100);

        textFieldNomeFilmeAdicionarSessao = new TextField();
        textFieldNomeFilmeAdicionarSessao.setPrefWidth(300);
        textFieldNomeFilmeAdicionarSessao.setPrefHeight(30);
        labelSessaoAdicionada = new Label("Nova Sessão");
        labelSessaoAdicionada.setPrefHeight(50);
        labelSessaoAdicionada.setPrefWidth(100);

        textFieldSessaoAdicionada = new TextField();
        textFieldSessaoAdicionada.setPrefWidth(300);
        textFieldSessaoAdicionada.setPrefHeight(30);
        botaoAdicionarSessao = new Button("Cadastrar Sessão");
        botaoAdicionarSessao.setPrefWidth(300);
        

        caixaLabelBotaoSessoesCLUD = new VBox();
        caixaLabelBotaoSessoesCLUD.getChildren().addAll(labelNomeFilmeAdicionarSessao, labelSessaoAdicionada, botaoAdicionarSessao);

        caixaTextFieldsSessaoCLUD = new VBox();
        caixaTextFieldsSessaoCLUD.setPadding(new Insets(10.5, 2, 10.5, 2));
        caixaTextFieldsSessaoCLUD.getChildren().addAll(textFieldNomeFilmeAdicionarSessao, textFieldSessaoAdicionada);

        caixaConteiner = new HBox();
        caixaConteiner.setSpacing(50);
        caixaConteiner.setStyle("-fx-background-color: red;");
        caixaConteiner.getChildren().addAll(caixaLabelsBotoesFilmeCLUD, caixaTextFieldFilmeCLUD, caixaLabelBotaoSessoesCLUD, caixaTextFieldsSessaoCLUD);

        telaOperacoesFilme = new Scene(caixaConteiner);

    }

    public Scene telaOperacoesFilme(){
        return telaOperacoesFilme;

    }

    public void voltar(){
        this.aplicacao.mudaCena(this.aplicacao.getTelaAdministrador().telaMenuAdministrador());

    }
    
}

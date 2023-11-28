package com.pratica.sistemadevendas.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TelaOperacoesSessao {
    
    private Label filmeLabel;
    private TextField filmeTextField;
    private Label dataInicioLabel;
    private TextField dataInicioTextField;
    private HBox caixaDigitaFilmeEDataInicio;

    private Button cadastraSessao;
    private Button deletaSessao;
    private HBox caixaCadastraDeletaSessao;

    private Button listarSessao;
    private Button atualizarSessao;
    private HBox caixaListarAtualizarSessao;

    private Label statusOperacaoLabel;
    private HBox caixaStatusOperacao;

    private Button botaoVoltar;
    private HBox caixaBotaoVoltar;

    private VBox caixaConteiner;

    public Scene telaOperacoesSessao;

    public Aplicacao aplicacao;

    public TelaOperacoesSessao(Aplicacao aplicacao){
        this.aplicacao = aplicacao;

        filmeLabel  = new Label("Filme:");        
        filmeTextField = new TextField();
        filmeTextField.setPrefWidth(300);
        dataInicioLabel  = new Label("Data de Início");        
        dataInicioTextField = new TextField();
        dataInicioTextField.setPrefWidth(300);
        caixaDigitaFilmeEDataInicio = new HBox();        
        caixaDigitaFilmeEDataInicio.setAlignment(Pos.CENTER);
        caixaDigitaFilmeEDataInicio.getChildren().addAll(filmeLabel, filmeTextField, dataInicioLabel, dataInicioTextField);

        cadastraSessao = new Button("Cadastrar Sessão");
        cadastraSessao.setPrefWidth(200);
        deletaSessao = new Button("Deletar Sessão");
        deletaSessao.setPrefWidth(200);
        caixaCadastraDeletaSessao = new HBox();
        caixaCadastraDeletaSessao.setSpacing(30);
        caixaCadastraDeletaSessao.setAlignment(Pos.CENTER);
        caixaCadastraDeletaSessao.getChildren().addAll(cadastraSessao, deletaSessao);

        listarSessao = new Button("Listar Sessão");
        listarSessao.setPrefWidth(200);
        atualizarSessao = new Button("atualizarSessao");
        atualizarSessao.setPrefWidth(200);
        caixaListarAtualizarSessao = new HBox();
        caixaListarAtualizarSessao.setSpacing(30);
        caixaListarAtualizarSessao.setAlignment(Pos.CENTER);
        caixaListarAtualizarSessao.getChildren().addAll(listarSessao, atualizarSessao);

        statusOperacaoLabel = new Label("Status");
        statusOperacaoLabel.setStyle("-fx-text-fill: yellow; -fx-font-size: 40px;");
        caixaStatusOperacao = new HBox();
        caixaStatusOperacao.getChildren().addAll(statusOperacaoLabel);

        botaoVoltar = new Button("Voltar");
        botaoVoltar.setOnAction(e -> voltar());
        botaoVoltar.setPrefWidth(100);
        caixaBotaoVoltar = new HBox();
        caixaBotaoVoltar.setAlignment(Pos.CENTER);
        caixaBotaoVoltar.getChildren().addAll(botaoVoltar);

        caixaConteiner = new VBox();
        caixaConteiner.setStyle("-fx-background-color: red;");
        caixaConteiner.setSpacing(100);
        caixaConteiner.setAlignment(Pos.CENTER);
        caixaConteiner.getChildren().addAll(caixaDigitaFilmeEDataInicio, caixaCadastraDeletaSessao,
        caixaListarAtualizarSessao, caixaStatusOperacao,caixaBotaoVoltar);

        telaOperacoesSessao = new Scene(caixaConteiner);


    }

    public Scene telaOperacoesSessao(){
        return this.telaOperacoesSessao;
    }
    
    public void voltar(){
        this.aplicacao.mudaCena(this.aplicacao.getTelaOperacoesFilme().telaOperacoesFilme());

    }
}

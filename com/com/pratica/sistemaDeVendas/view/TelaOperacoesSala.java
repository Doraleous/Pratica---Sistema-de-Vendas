package com.pratica.sistemadevendas.view;

import javax.xml.soap.SOAPMessage;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TelaOperacoesSala {

    private Label salaNomeLabel;
    private TextField salaDigitaTextField;
    private Label sessaoLabel;
    private TextField sessaoDigitaTextField;
    private HBox digitaSalaESessao;

    private Button cadastraSalaComum;
    private Button cadastraSala3D;
    private HBox caixaSalasComumE3D;

    private Button cadastraSalaXD;
    private Button cadastraSalaXD3D;
    private HBox caixaSalasXDEXD3D;

    private Button deletarSala;
    private Button listarSala;
    private Button atualizarSala;
    private HBox caixaDeletaListaAtualiza;

    private Label statusOperacaoLabel;
    private HBox caixaStatusOperacao;

    private Button botaoVoltar;
    private HBox caixaBotaoVoltar;

    private VBox caixaConteiner;

    private Scene telaOperacoesSala;

    private Aplicacao aplicacao;

    public TelaOperacoesSala(Aplicacao aplicacao){
        this.aplicacao = aplicacao;

        salaNomeLabel = new Label("Nome:");
        salaDigitaTextField = new TextField();
        salaDigitaTextField.setPrefWidth(200);
        sessaoLabel = new Label("Sessão:");
        sessaoDigitaTextField = new TextField();
        sessaoDigitaTextField.setPrefWidth(200);
        digitaSalaESessao = new HBox();
        digitaSalaESessao.setAlignment(Pos.CENTER);
        digitaSalaESessao.getChildren().addAll(salaNomeLabel, salaDigitaTextField, sessaoLabel, sessaoDigitaTextField);

        cadastraSalaComum = new Button("Cadastrar Sala Comum");
        cadastraSalaComum.setPrefWidth(200);
        cadastraSala3D = new Button("Cadastrar Sala 3D");
        cadastraSalaComum.setPrefWidth(200);
        caixaSalasComumE3D = new HBox();
        caixaSalasComumE3D.setSpacing(30);
        caixaSalasComumE3D.setAlignment(Pos.CENTER);
        caixaSalasComumE3D.getChildren().addAll(cadastraSalaComum, cadastraSala3D);

        cadastraSalaXD = new Button("Cadastrar Sala XD");
        cadastraSalaXD.setPrefWidth(200);
        cadastraSalaXD3D = new Button("Cadastrar Sala XD3D");
        cadastraSalaXD3D.setPrefWidth(200);
        caixaSalasXDEXD3D = new HBox();
        caixaSalasXDEXD3D.setSpacing(30);
        caixaSalasXDEXD3D.setAlignment(Pos.CENTER);
        caixaSalasXDEXD3D.getChildren().addAll(cadastraSalaXD, cadastraSalaXD3D);

        deletarSala = new Button("Deletar Sala");
        deletarSala.setPrefWidth(200);
        listarSala = new Button("Listar Sala");
        listarSala.setPrefWidth(200);
        atualizarSala = new Button("Deletar Sala");
        atualizarSala.setPrefWidth(200);
        caixaDeletaListaAtualiza = new HBox();
        caixaDeletaListaAtualiza.setSpacing(30);
        caixaDeletaListaAtualiza.setAlignment(Pos.CENTER);
        caixaDeletaListaAtualiza.getChildren().addAll(deletarSala, listarSala, atualizarSala);

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
        caixaConteiner.getChildren().addAll(digitaSalaESessao, caixaSalasComumE3D, caixaSalasXDEXD3D,
        caixaDeletaListaAtualiza, caixaStatusOperacao, caixaBotaoVoltar);
        
        telaOperacoesSala = new Scene(caixaConteiner);


    }

    public Scene telaOperacoesSala(){
        return this.telaOperacoesSala;
    }

    public void voltar(){
        this.aplicacao.mudaCena(this.aplicacao.getTelaOperacoesFilme().telaOperacoesFilme());

    }
    
}

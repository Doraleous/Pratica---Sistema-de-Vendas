package com.pratica.sistemadevendas.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class TelaOperacoesFilme {

   private Button botaoFilme;
   private Button botaoSala;
   private Button botaoSessao;
   private Button botaoVoltar;
   private Region entreSessaoESair;

   private VBox caixaBotoes;
   

    private Scene telaOperacoesFilme;

    private Aplicacao aplicacao;

    public TelaOperacoesFilme(Aplicacao aplicacao){
        this.aplicacao = aplicacao;

        botaoFilme = new Button("Filme");
        botaoFilme.setPrefWidth(300);
        botaoFilme.setOnAction(e -> irParaTelaDeFilmesCLUD());

        botaoSala = new Button("Sala");
        botaoSala.setPrefWidth(300);
        botaoSala.setOnAction(e -> irParaTelaDeOperacoesSala());

        botaoSessao = new Button("Sessão");
        botaoSessao.setPrefWidth(300);
        botaoSessao.setOnAction(e -> irParaTelaOperacoesSessao());

        entreSessaoESair = new Region();
        entreSessaoESair.setPrefHeight(80);

        botaoVoltar = new Button("Voltar");
        botaoVoltar.setPrefWidth(100);

        botaoVoltar.setOnAction(e -> voltar());

        caixaBotoes = new VBox();
        caixaBotoes.setSpacing(15);
        caixaBotoes.setStyle("-fx-background-color: red;");
        caixaBotoes.getChildren().addAll(botaoFilme, botaoSala, botaoSessao, entreSessaoESair, botaoVoltar);
        caixaBotoes.setAlignment(Pos.CENTER);


        telaOperacoesFilme = new Scene(caixaBotoes);

    }

    public Scene telaOperacoesFilme(){
        return telaOperacoesFilme;

    }

    public void voltar(){
        this.aplicacao.mudaCena(this.aplicacao.getTelaAdministrador().telaMenuAdministrador());

    }

    public void irParaTelaDeFilmesCLUD(){
        this.aplicacao.mudaCena(this.aplicacao.getTelaOperacoesFilmesCLUD().telaOperacoesFilmesCLUD());

    }

    public void irParaTelaDeOperacoesSala(){
        this.aplicacao.mudaCena(this.aplicacao.gettTelaOperacoesSala().telaOperacoesSala());
    }

    public void irParaTelaOperacoesSessao(){
        this.aplicacao.mudaCena(this.aplicacao.getTelaOperacoesSessao().telaOperacoesSessao());
    }
    
}

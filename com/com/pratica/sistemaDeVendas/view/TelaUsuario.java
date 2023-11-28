package com.pratica.sistemadevendas.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

public class TelaUsuario {

    private Button botaoFilmes;
    private Button botaoLoja;
    private HBox caixaFilmesLoja;

    private Button botaoSair;
    private HBox caixaBotaoSair;

    private VBox caixaConteiner;

    public Scene telaUsuario;

    private Aplicacao aplicacao;

    public TelaUsuario(Aplicacao aplicacao) {
        this.aplicacao = aplicacao;

        botaoFilmes = new Button("Filmes");
        botaoFilmes.setPrefWidth(300);
        botaoLoja = new Button("Loja");
        botaoLoja.setPrefWidth(300);
        caixaFilmesLoja = new HBox();
        caixaFilmesLoja.setSpacing(50);
        caixaFilmesLoja.setAlignment(Pos.CENTER);
        caixaFilmesLoja.getChildren().addAll(botaoFilmes, botaoLoja);

        botaoSair = new Button("Sair");
        botaoSair.setPrefWidth(300);
        botaoSair.setOnAction(e -> sair());
        caixaBotaoSair = new HBox();
        caixaBotaoSair.setAlignment(Pos.CENTER);
        caixaBotaoSair.getChildren().addAll(botaoSair);

        caixaConteiner = new VBox();
        caixaConteiner.setAlignment(Pos.CENTER);
        caixaConteiner.getChildren().addAll(caixaFilmesLoja, caixaBotaoSair);

        telaUsuario = new Scene(caixaConteiner);
    }

    public Scene telaOperacoesSala() {
        return this.telaUsuario;

    }

    public void sair() {
        this.aplicacao.estagioAtual().close();
    }
}
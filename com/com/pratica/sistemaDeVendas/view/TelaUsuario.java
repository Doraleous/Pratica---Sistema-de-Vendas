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
        botaoFilmes.setStyle("-fx-border-color: #00008B; -fx-border-width: 4px;");
        botaoFilmes.setOnAction(e -> irParaTelaCompraFilmes());
        botaoLoja = new Button("Loja");
        botaoLoja.setPrefWidth(300);
        botaoLoja.setStyle("-fx-border-color: #00008B; -fx-border-width: 4px;");
        caixaFilmesLoja = new HBox();
        caixaFilmesLoja.setSpacing(50);
        caixaFilmesLoja.setAlignment(Pos.CENTER);
        caixaFilmesLoja.getChildren().addAll(botaoFilmes, botaoLoja);

        botaoSair = new Button("Sair");
        botaoSair.setPrefWidth(200);
        botaoSair.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        botaoSair.setOnAction(e -> sair());
        caixaBotaoSair = new HBox();
        caixaBotaoSair.setAlignment(Pos.CENTER);
        caixaBotaoSair.getChildren().addAll(botaoSair);

        caixaConteiner = new VBox();
        caixaConteiner.setAlignment(Pos.CENTER);
        caixaConteiner.setStyle("-fx-background-color: red;");
        caixaConteiner.getChildren().addAll(caixaFilmesLoja, caixaBotaoSair);

        telaUsuario = new Scene(caixaConteiner);
    }

    public Scene telaUsuario() {
        return this.telaUsuario;

    }

    public void sair() {
        this.aplicacao.estagioAtual().close();
    }

    public void irParaTelaCompraFilmes(){
        this.aplicacao.mudaCena(this.aplicacao.getTelaComprarFilmes().telaComprarFilmes());
    }
}
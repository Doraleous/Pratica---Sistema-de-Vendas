package com.pratica.sistemadevendas.view;

import java.sql.SQLException;
import java.util.ArrayList;

import com.pratica.sistemadevendas.controller.FilmeController;
import com.pratica.sistemadevendas.model.Filme;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TelaComprarFilmes {

    private GridPane caixaFilmesEBotoesComprar;

    private FilmeController filmeController;

    private Button botaoVoltar;
    private HBox caixaBotaoVoltar;

    private Label estamosFechados;

    private VBox caixaConteiner;

    private Scene telaComprarFilmes;

    public Aplicacao aplicacao;

    private String tituloFilme;

    public TelaComprarFilmes(Aplicacao aplicacao) throws SQLException {
        this.aplicacao = aplicacao;
        this.filmeController = new FilmeController(this.aplicacao);
        ArrayList<Filme> listaDeFilmes = filmeController.verificaListaDeFilmes();
        if (listaDeFilmes != null) {

            int linha = 0, colunaFilme = 0, colunaBotaoComprar = 1;

            caixaFilmesEBotoesComprar = new GridPane();
            caixaFilmesEBotoesComprar.setHgap(60);
            caixaFilmesEBotoesComprar.setVgap(20);

            for (Filme filme : listaDeFilmes) {
                Label labelNomeFilme = new Label(filme.getTitulo());
                labelNomeFilme.setStyle("-fx-font-size: 15px;");
                Button comprar = new Button("Comprar");
                if (linha % 2 == 0) {
                    comprar.setStyle("-fx-border-color: purple; -fx-border-width: 5px;");
                } else {
                    comprar.setStyle("-fx-border-color: #6A5ACD; -fx-border-width: 5px;");
                }

                comprar.setOnAction(e -> irParaTelaDeSessoes());

                caixaFilmesEBotoesComprar.add(labelNomeFilme, colunaFilme, linha);
                caixaFilmesEBotoesComprar.add(comprar, colunaBotaoComprar, linha);
                linha++;
            }

            caixaFilmesEBotoesComprar.setAlignment(Pos.CENTER);

            botaoVoltar = new Button("Voltar");
            botaoVoltar.setPrefWidth(200);
            botaoVoltar.setOnAction(e -> voltar());
            caixaBotaoVoltar = new HBox();
            caixaBotaoVoltar.getChildren().addAll(botaoVoltar);
            caixaBotaoVoltar.setAlignment(Pos.CENTER);

            caixaConteiner = new VBox(50);
            caixaConteiner.getChildren().addAll(caixaFilmesEBotoesComprar, caixaBotaoVoltar);
            caixaConteiner.setAlignment(Pos.CENTER);
            caixaConteiner.setStyle("-fx-background-color: red;");

        } else {
            estamosFechados = new Label("Estamos fechados, obrigado pela paciência!");
            caixaConteiner = new VBox();
            caixaConteiner.getChildren().add(estamosFechados);
            caixaConteiner.setAlignment(Pos.CENTER);
        }

        telaComprarFilmes = new Scene(caixaConteiner);

    }

    public void irParaTelaDeSessoes() {
        this.aplicacao.mudaCena(this.aplicacao.getTelaDeSessoes().telaDeSessoes());
    }

    public void voltar() {
        this.aplicacao.mudaCena(this.aplicacao.getTelaUsuario().telaUsuario());
    }

    public Scene telaComprarFilmes() {
        return this.telaComprarFilmes;
    }

}